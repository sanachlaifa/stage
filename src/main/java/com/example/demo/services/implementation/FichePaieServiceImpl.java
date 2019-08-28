package com.example.demo.services.implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entities.Abattement;
import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.FichePaie;
import com.example.demo.model.entities.ImpotRevenu;
import com.example.demo.model.entities.Prime;
import com.example.demo.model.enumeration.Charge;
import com.example.demo.model.entities.Parametres;

import com.example.demo.repositories.FichePaieRepo;
import com.example.demo.services.AbattementService;
import com.example.demo.services.ContratService;
import com.example.demo.services.FichePaieService;
import com.example.demo.services.ImpotService;
import com.example.demo.services.ParametresService;
import com.example.demo.services.PrimeService;


@Service
public class FichePaieServiceImpl implements FichePaieService {

	
	
	
	@Autowired
	private FichePaieRepo ficheRepository ;
	
	@Autowired
    private ContratService contratService;
	
	@Autowired
    private PrimeService primeService;
	
	@Autowired
    private FichePaieService ficheService;
	
	@Autowired
    private ParametresService parametreService;
	
	@Autowired
    private AbattementService abattementService;
	
	@Autowired
    private ImpotService impotService;
	
	@Override
	public FichePaie getFichePaie(Long id) {
		 FichePaie fiche = ficheRepository.findById(id).get();
	        if (fiche == null) {
	            System.out.println("erreur get");
	        }
	        return fiche;
	}
	
	 @Transactional
		@Override
		public FichePaie saveFichePaieContrat(FichePaie fiche, Contrat contrat) {
			 fiche.setContrat(contrat);
		        return ficheRepository.save(fiche);
		}
	 
	 @Transactional
		@Override
		public FichePaie updateFichePaieContrat(Long id, FichePaie fiche, Contrat contrat) {
			   getFichePaie(id);
		        fiche.setIdFiche(id);
		        fiche.setContrat(contrat);
		        return saveFichePaieContrat(fiche, contrat);
		} ;
	 
	@Override
	public List<FichePaie> getAllContratFichePaie(Long id) {
		Contrat contrat = contratService.getContrat(id);
        return (List<FichePaie>) ficheRepository.findByContrat(contrat);
	}
	
	
	public Contrat getContrat (FichePaie fiche){
		return fiche.getContrat();
	}
	
	


	 @Transactional
	@Override
	public void deleteFichePaie(Long id) {
		 try {
	            ficheRepository.deleteById(id);
	        } catch (EmptyResultDataAccessException e) {
	            System.out.println("erreur delete");
	        }	
	}

	 @Override
		public float netSocial(Long id) {
			FichePaie f = getFichePaie(id);
		    Contrat c =	ficheService.getContrat(f);
		    List<Prime> primes = primeService.getAllContratPrime(c.getId());
		   float res = 0 , val=0;
		  for (Prime prime : primes) {
			res+= prime.getValeurPrime();
		}
		   res +=c.getSalaireBase();
		  List<Parametres> par = parametreService.getAllContratParametres(c.getId());
		   for (Parametres parametres : par) {
			if(parametres.getNomPar() == Charge.chages_patronales) {
				val = parametres.getValPar();
			}
		}
		  
         
		   return res - ((res*val)/100);
		}
	 
	 @Override
		public Double netFP(Long id) {
			float netSocial = ficheService.netSocial(id);
			return (netSocial*12)*0.9;
		}
	 
	 public Double imposable(Long id) {
			FichePaie f = getFichePaie(id);
		    Contrat c =	ficheService.getContrat(f);
			Double abt =0.0 ;
			List<Abattement> stt = abattementService.getAllContratAbattement(c.getId());
			for (Abattement abattement : stt) {
				abt +=abattement.getValeur();
			}
			return ficheService.netFP(id)-abt;
		}

	 
	@Override
	public Double impot1(Long id) {
		return (ficheService.imposable(id)/12)*0.01;
	}

	@Override
	public Double retenuImpot(Long id) {
		Double res = 0.0; 
		int index =1;
		Double imp = ficheService.imposable(id);
		FichePaie f = getFichePaie(id);
	    Contrat c =	ficheService.getContrat(f);
		List<ImpotRevenu> impots =impotService.getAllContratImpot(c.getId());
		
	
		while ((imp - impots.get(index-1).getBorneSup()) > 0.0) {
			
			//if((imp - impots.get(index-1).getBorneSup()) > 0.0) {
				//res= impots.get(index).getBorneSup();
				//res+=(imp - impots.get(index).getBorneSup())  * impots.get(index).getTaux();
			//}else {
				res+=((Math.min(imp, impots.get(index).getBorneSup()))-impots.get(index).getBorneInf()) * impots.get(index).getTaux();
			//}
			index ++;
		}
		
	
	return (res/12)-ficheService.impot1(id) ;
	}

	@Override
	public Double netApayer(Long id) {
		return  ficheService.netSocial(id) - ficheService.retenuImpot(id) -ficheService.impot1(id) ;
	}

	


	
}



   