package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Employee;



public interface EmployeService {
    
    Employee getEmployee(Long id);
    
    List<Employee> getAllEmployee();
    
    Employee saveEmployee(Employee employee);
    
    void deleteEmployee(Long id);
    
    Employee updateEmployee(long id, Employee employee);
}
