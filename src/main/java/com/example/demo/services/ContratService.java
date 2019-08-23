package com.example.demo.services;

import java.util.List;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.Employee;

public interface ContratService {
    Contrat getContrat(Long id);
	 List<Contrat> getAllEmployeeContrat(Long idEmploye);
    Contrat saveContratEmployee(Contrat contrat,Employee employe);  
    void deleteContrat(Long id);
    Contrat updateContratEmployee(long id, Contrat contrat, Employee employee);
    List<Contrat> getContratEmploye(Employee employee);
}


