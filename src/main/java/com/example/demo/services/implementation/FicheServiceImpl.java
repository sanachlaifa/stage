package com.example.demo.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.Employee;
import com.example.demo.model.entities.FichePaie;
import com.example.demo.repositories.FichePaieRepo;
import com.example.demo.services.ContratService;
import com.example.demo.services.EmployeService;
import com.example.demo.services.FichePaieService;

@Service
public class FicheServiceImpl implements FichePaieService {

	@Autowired
	private FichePaieRepo ficheRepo ;
	@Autowired
	private EmployeService employeService ;
	
	@Autowired
	private ContratService contratService ;
	
	@Override
	public FichePaie getFichePaie(Long id) {
		return ficheRepo.findById(id).get();
	}

	@Transactional
	@Override
	public void deleteFichePaie(Long id) {
	try {
		ficheRepo.deleteById(id);
	}catch(EmptyResultDataAccessException e) {
		System.out.println("erreur deleting fiche de paie");
	}
		
	}

	@Override
	public List<FichePaie> getAllFichePaie() {
		return (List<FichePaie>) ficheRepo.findAll();
	}

	@Transactional
	@Override
	public FichePaie saveFichePaie(FichePaie fiche, Long idEmploye , Long idContrat) {
		Employee employe = employeService.getEmployee(idEmploye);
		Contrat contrat = contratService.getContrat(idContrat);
		fiche.setEmployee(employe);
		fiche.setContrat(contrat);
		return ficheRepo.save(fiche);
	}

	@Transactional
	@Override
	public FichePaie updateFichePaie(long id, FichePaie fiche, Long idEmploye , Long idContrat) {
		Employee employe = employeService.getEmployee(idEmploye);
		Contrat contrat = contratService.getContrat(idContrat);
		getFichePaie(id);
		fiche.setIdFiche(id);
		fiche.setEmployee(employe);
		fiche.setContrat(contrat);
		return saveFichePaie(fiche,idEmploye,idContrat);
	}

	@Override
	public List<FichePaie> getFichePaieEmploye(Long id) {
		Employee employe = employeService.getEmployee(id);
		return (List<FichePaie>) ficheRepo.findByEmployee(employe) ;
	}

}
