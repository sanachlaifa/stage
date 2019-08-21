package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Employee;
import com.example.demo.repositories.ContratRepo;
import com.example.demo.services.ContratService;
import com.example.demo.services.EmployeService;
@Service
public class ContratServiceImpl implements ContratService {

	 @Autowired
	    private ContratRepo contratRepository;
	    
	    @Autowired
	    private EmployeService employeService;
	
	@Override
	public Contrat getContrat(Long id) {
		Contrat contrat=contratRepository.findById(id).get();
        if (contrat == null) {
            System.out.println("erreur get");
        }
        return contrat;
	}

	@Override
	public List<Contrat> getAllContrat() {
		 return (List<Contrat>) contratRepository.findAll();
	}
	
	
	 @Transactional
	@Override
	public Contrat saveContrat(Contrat contrat, Long idEmploye) {
		 if(employeService.getEmployee(idEmploye) == null) {
	            System.out.println("erreur employe");
	        } else {
	           
	            contrat.setEmployee(employeService.getEmployee(idEmploye));
	            return contratRepository.save(contrat);    
	        }
	        return null;
	    }
	

	 @Transactional
	@Override
	public void deleteContrat(Long id) {
		 try {
	            contratRepository.deleteById(id);
	        } catch (EmptyResultDataAccessException e) {
	            System.out.println("erreur delete");
	        }
		
	}

	 @Transactional
	@Override
	public Contrat updateContrat(long id, Contrat contrat, Long idEmploye) {
		   getContrat(id);
	        contrat.setId(id);
	        return saveContrat(contrat, idEmploye);
	    }
	

	@Override
	public List<Contrat> getContratEmploye(Employee employee) {
		List<Contrat> contrats=contratRepository.findByEmployee(employee);
        if (contrats == null) {
            System.out.println("erreur get");
        }
        return contrats;
	}

	


}
