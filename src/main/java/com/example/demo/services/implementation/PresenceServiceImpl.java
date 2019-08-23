package com.example.demo.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Employee;
import com.example.demo.model.entities.Presence;
import com.example.demo.repositories.PresenceRepo;
import com.example.demo.services.EmployeService;
import com.example.demo.services.PresenceService;

@Service
public class PresenceServiceImpl implements PresenceService {

	@Autowired
	private PresenceRepo presenceRepo ;
	
	@Autowired
	private EmployeService employeService ;
	
	@Override
	public Presence getPresence(Long id) {
		return presenceRepo.findById(id).get() ;
	}

	@Transactional
	@Override
	public void deletePresence(Long id) {
		try {
			presenceRepo.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			System.out.println("erreur delete");
		}
		
	}

	@Override
	public List<Presence> getAllPresence() {
		return (List<Presence>) presenceRepo.findAll() ;
	}

	@Transactional
	@Override
	public Presence savePresenceEmploye(Presence presence, Employee employe) {
		presence.setEmployee(employe);
		return presenceRepo.save(presence) ;
	}

	@Transactional
	@Override
	public Presence updatePresenceEmploye(long id, Presence presence, Employee employe) {
	    getPresence(id);
	    presence.setIdPres(id);
	    presence.setEmployee(employe);
		return savePresenceEmploye(presence, employe);
	}

	@Override
	public List<Presence> getPresenceEmploye(Long id) {
		Employee employe = employeService.getEmployee(id);
		return (List<Presence>) presenceRepo.findByEmployee(employe);
	}

}
