package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Employee;

public interface ContratService {
    Contrat getContrat(Long id);
    List<Contrat> getAllContrat();
    Contrat saveContrat(Contrat contrat, Long idEmploye);  
    void deleteContrat(Long id);
    Contrat updateContrat(long id, Contrat contrat, Long idEmploye);
    List<Contrat> getContratEmploye(Employee employee);
}


