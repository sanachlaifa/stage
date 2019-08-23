package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entities.Enfant;
import com.example.demo.model.entities.Employee;
import com.example.demo.repositories.EnfantRepo;
import com.example.demo.services.EnfantService;
import com.example.demo.services.EmployeService;
@Service
public class EnfantServiceImpl implements EnfantService{


	 @Autowired
	    private EnfantRepo enfantRepository;
	    
	    @Autowired
	    private EmployeService employeService;
	
	@Override
	public Enfant getEnfant(Long id) {
		Enfant enfant=enfantRepository.findById(id).get();
     if (enfant == null) {
         System.out.println("erreur get");
     }
     return enfant;
	}

	@Override
	public List<Enfant> getAllEnfant() {
		 return (List<Enfant>) enfantRepository.findAll();
	}
	
	
	 @Transactional
	@Override
	public Enfant saveEnfant(Enfant enfant, Long idEmploye) {
		 if(employeService.getEmployee(idEmploye) == null) {
	            System.out.println("erreur employe");
	        } else {
	           
	            enfant.setEmployee(employeService.getEmployee(idEmploye));
	            return enfantRepository.save(enfant);    
	        }
	        return null;
	    }
	

	 @Transactional
	@Override
	public void deleteEnfant(Long id) {
		 try {
	            enfantRepository.deleteById(id);
	        } catch (EmptyResultDataAccessException e) {
	            System.out.println("erreur delete");
	        }
		
	}

	 @Transactional
	@Override
	public Enfant updateEnfant(long id, Enfant enfant, Long idEmploye) {
		   getEnfant(id);
	        enfant.setId(id);
	        return saveEnfant(enfant, idEmploye);
	    }
	

	@Override
	public List<Enfant> getEnfantEmploye(Employee employee) {
		List<Enfant> enfants=enfantRepository.findByEmployee(employee);
     if (enfants == null) {
         System.out.println("erreur get");
     }
     return enfants;
	}



}
