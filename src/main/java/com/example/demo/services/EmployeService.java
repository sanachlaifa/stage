package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Employé;



public interface EmployeService {
	 public Employé trouverEmployé (Long p) ;
	 public Employé AjouterEmployé (Employé p);
	 public Employé modifierEmployé (Long p , float val);
	 public List<Employé> consulterEmployés ();
	 public void supprimerEmployé (Long p);
	 public List<Employé>  chercherEmployé (String criteria);
}
