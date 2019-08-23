package com.example.demo.services;

import java.util.List;

import com.example.demo.model.entities.Enfant;
import com.example.demo.model.entities.Employee;

public interface EnfantService {
    Enfant getEnfant(Long id);
    List<Enfant> getAllEnfant();
    Enfant saveEnfant(Enfant enfant, Long idEmploye);  
    void deleteEnfant(Long id);
    Enfant updateEnfant(long id, Enfant enfant, Long idEmploye);
    List<Enfant> getEnfantEmploye(Employee employee);
}
