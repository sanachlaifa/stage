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
public class EnfantServiceImpl implements EnfantService {

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
	public List<Enfant> getAllEmployeeEnfant(Long idEmploye) {
		Employee employee = employeService.getEmployee(idEmploye);
		return (List<Enfant>) enfantRepository.findByEmployee(employee);
	}
	
	
	
	
	 @Transactional
		@Override
		public Enfant saveEnfantEmployee (Enfant enfant, Employee employe) {
		            enfant.setEmployee(employe);
		            return enfantRepository.save(enfant);    
		       
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

	
	

	@Override
	public List<Enfant> getEnfantEmploye(Employee employee) {
		List<Enfant> enfants=enfantRepository.findByEmployee(employee);
        if (enfants == null) {
            System.out.println("erreur get");
        }
        return enfants;
	}


	 @Transactional
		@Override
		public Enfant updateEnfantEmployee(long id, Enfant enfant, Employee employe) {
			   getEnfant(id);
		        enfant.setId(id);
		        return saveEnfantEmployee(enfant, employe);
		    }


}
