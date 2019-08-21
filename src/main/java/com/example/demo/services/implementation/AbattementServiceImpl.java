package com.example.demo.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Abattement;
import com.example.demo.repositories.AbattementRepo;
import com.example.demo.services.AbattementService;


@Service
public class AbattementServiceImpl implements AbattementService {

	@Autowired
	private AbattementRepo abattementRepo ;
	
	@Override
	public Abattement getAbattement(Long id) {
		return abattementRepo.findById(id).get();
	}

	@Transactional
	@Override
	public void deleteAbattement(Long id) {
		abattementRepo.deleteById(id);
		
	}

	@Override
	public List<Abattement> getAllAbattement() {
		return (List<Abattement>) abattementRepo.findAll();
	}

	@Transactional
	@Override
	public Abattement saveAbattement(Abattement abattement) {
		return abattementRepo.save(abattement);
	}

	@Transactional
	@Override
	public Abattement updateAbattement(long id, Abattement abattement) {
		getAbattement(id);
        abattement.setIdAbat(id);
        return saveAbattement(abattement);
	}

}
