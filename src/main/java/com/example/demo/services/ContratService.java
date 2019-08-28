package com.example.demo.services;

import java.util.List;
import java.util.Set;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.Employee;
import com.example.demo.model.entities.Parametres;
import com.example.demo.model.entities.Prime;

public interface ContratService {
    Contrat getContrat(Long id);
	 List<Contrat> getAllEmployeeContrat(Long idEmploye);
    Contrat saveContratEmployee(Contrat contrat,Employee employe);  
    void deleteContrat(Long id);
    Contrat updateContratEmployee(long id, Contrat contrat, Employee employee);
    List<Contrat> getContratEmploye(Employee employee);
    Set<Prime> getPrimes(Contrat contrat);
    Set<Parametres> getPars(Contrat contrat);
}


