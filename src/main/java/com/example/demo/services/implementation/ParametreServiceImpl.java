package com.example.demo.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.Parametres;
import com.example.demo.repositories.ParametresRepo;
import com.example.demo.services.ContratService;
import com.example.demo.services.ParametresService;

@Service
public class ParametreServiceImpl implements ParametresService {

	@Autowired
	private ParametresRepo parametreRepo ;
	
	@Autowired
	private ContratService contratService ;
	
	
	@Override
	public Parametres getParametre(Long id) {
		return parametreRepo.findById(id).get();
	}

	@Transactional
	@Override
	public void deleteParametre(Long id) {
	try {
		parametreRepo.deleteById(id);
	}catch(EmptyResultDataAccessException e) {
		System.out.println("erreur deleting parameter");
	}
		
	}

	@Override
	public List<Parametres> getAllContratParametres(Long id) {
		Contrat contrat = contratService.getContrat(id);
		return (List<Parametres>) parametreRepo.findByContrat(contrat);
	}

	@Transactional
	@Override
	public Parametres saveParametresContrat(Parametres parm, Contrat contrat) {
		parm.setContrat(contrat);
		return parametreRepo.save(parm);
	}

	@Transactional
	@Override
	public Parametres updateParametresContrat(Long id, Parametres parm, Contrat contrat) {
		getParametre(id);
		parm.setIdPar(id);
		parm.setContrat(contrat);
		return saveParametresContrat(parm, contrat);
	}

}
