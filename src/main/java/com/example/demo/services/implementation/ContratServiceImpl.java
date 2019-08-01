package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Contrat;
import com.example.demo.repositories.ContratRepo;
import com.example.demo.services.ContratService;
@Service
public class ContratServiceImpl implements ContratService {

	@Autowired
	private ContratRepo contratRepo ;	
	
	@Override
	@Transactional
	public Contrat AjouterContrat(Contrat c) {
		return contratRepo.save(c) ;
	}


	@Override
	@Transactional
	public void supprimerContrat(Long id) {
             contratRepo.deleteById(id);		
	}

	@Override
	public List<Contrat> consulterContrats() {
		return contratRepo.findAll();
	}


}
