package com.example.demo.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Employé;
import com.example.demo.repositories.EmployeRepo;
import com.example.demo.services.EmployeService;


@Service
public class EmployeServiceImpl implements EmployeService{

	@Autowired
	private EmployeRepo employeRepo ;
	
	@Override
	public Employé trouverEmployé(Long p) {
		return employeRepo.getOne(p);
	}

	@Override
	@Transactional
	public Employé AjouterEmployé(Employé p) {
		return employeRepo.save(p);
	}

	@Override
	public Employé modifierEmployé(Long p, float val) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employé> consulterEmployés() {
		return employeRepo.findAll();
	}

	@Override
	@Transactional
	public void supprimerEmployé(Long p) {
     Employé emp = trouverEmployé(p);
     employeRepo.delete(emp);		
	}

	@Override
	public List<Employé> chercherEmployé(String c) {
	
		List <Employé> l = new ArrayList <Employé> ();
		List <Employé> lp = consulterEmployés();
		for (Employé emp : lp) {
			if(emp.getNomEmployé().contains(c)) {
				l.add(emp);
			}
		}
		return l;
	}

}
