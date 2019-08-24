package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.FichePaie;
import com.example.demo.repositories.FichePaieRepo;
import com.example.demo.services.ContratService;
import com.example.demo.services.FichePaieService;


@Service
public class FichePaieServiceImpl implements FichePaieService {

	
	
	
	@Autowired
	private FichePaieRepo ficheRepository ;
	
	@Autowired
    private ContratService contratService;
	
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
	
	
	
	
	


	 @Transactional
	@Override
	public void deleteFichePaie(Long id) {
		 try {
	            ficheRepository.deleteById(id);
	        } catch (EmptyResultDataAccessException e) {
	            System.out.println("erreur delete");
	        }	
	}
	
}



   