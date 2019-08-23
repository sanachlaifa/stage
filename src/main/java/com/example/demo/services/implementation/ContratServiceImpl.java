package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.Employee;
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
	public List<Contrat> getAllEmployeeContrat(Long idEmploye) {
		Employee employee = employeService.getEmployee(idEmploye);
		return (List<Contrat>) contratRepository.findByEmployee(employee);
	}
	
	
	
	 @Transactional
		@Override
		public Contrat saveContratEmployee (Contrat contrat, Employee employe) {
		            contrat.setEmployee(employe);
		            return contratRepository.save(contrat);    
		       
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
		public Contrat updateContratEmployee(long id, Contrat contrat, Employee employe) {
			   getContrat(id);
		        contrat.setId(id);
		        return saveContratEmployee(contrat, employe);
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
