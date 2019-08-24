package com.example.demo.services;

import java.util.List;

import com.example.demo.model.entities.Enfant;
import com.example.demo.model.entities.Employee;

public interface EnfantService {
    Enfant getEnfant(Long id);
	 List<Enfant> getAllEmployeeEnfant(Long idEmploye);
    Enfant saveEnfantEmployee(Enfant enfant,Employee employe);  
    void deleteEnfant(Long id);
    Enfant updateEnfantEmployee(long id, Enfant enfant, Employee employee);
    List<Enfant> getEnfantEmploye(Employee employee);
}