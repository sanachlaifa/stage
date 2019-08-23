package com.example.demo.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Abattement;
import com.example.demo.model.entities.Contrat;
import com.example.demo.repositories.AbattementRepo;
import com.example.demo.services.AbattementService;
import com.example.demo.services.ContratService;


@Service
public class AbattementServiceImpl implements AbattementService {

	@Autowired
	private AbattementRepo abattementRepo ;
	
	@Autowired
	private ContratService contratService ;
	
	@Override
	public Abattement getAbattement(Long id) {
		return abattementRepo.findById(id).get();
	}

	@Transactional
	@Override
	public void deleteAbattement(Long id) {
		abattementRepo.deleteById(id);
		
	}

	

	@Transactional
	@Override
	public Abattement saveAbattementContrat(Abattement abattement, Contrat contrat) {
		abattement.setContrat(contrat);
		return abattementRepo.save(abattement);
	}



	
	
	@Override
	public List<Abattement> getAllContratAbattement(Long id) {
		Contrat contrat = contratService.getContrat(id);
		return (List<Abattement>) abattementRepo.findByContrat(contrat);
	}

	@Transactional
	@Override
	public Abattement updateAbattementContrat (Long id, Abattement abattement,Contrat contrat) {
		getAbattement(id);
        abattement.setIdAbat(id);
        abattement.setContrat(contrat);
        return saveAbattementContrat(abattement,contrat);
	}

	
}
