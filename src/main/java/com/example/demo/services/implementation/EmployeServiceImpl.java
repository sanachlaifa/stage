package com.example.demo.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeRepo;
import com.example.demo.services.EmployeService;


@Service
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	private EmployeRepo employeeRepository ;

	@Override
	public Employee getEmployee(Long id) {
		   return employeeRepository.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmployee() {
		  return (List<Employee>) employeeRepository.findAll();
	}

	 @Transactional
	@Override
	public Employee saveEmployee(Employee employee) {
		 return employeeRepository.save(employee);
	}

	 @Transactional
	@Override
	public void deleteEmployee(Long id) {
		  try {
	            employeeRepository.deleteById(id);
	        } catch (EmptyResultDataAccessException e) {
	            System.out.println("erreur delete");
	        }
		
	}

	 @Transactional
	@Override
	public Employee updateEmployee(long matricule, Employee employee) {
		    getEmployee(matricule);
	        employee.setMatricule(matricule);
	        return saveEmployee(employee);
	}
	

	
}
