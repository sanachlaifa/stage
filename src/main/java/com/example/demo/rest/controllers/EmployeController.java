package com.example.demo.rest.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.Employee;
import com.example.demo.rest.dto.ContratDto;
import com.example.demo.rest.dto.EmployeDto;
import com.example.demo.services.ContratService;
import com.example.demo.services.EmployeService;
@CrossOrigin("*")
@RestController()
public class EmployeController {
	@Autowired
	private EmployeService employeService ;
	 @Autowired
	private ContratService contratService;
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/ajouterEmploye")
	public Object addEmploye(@Valid @RequestBody EmployeDto employeDto) {
		Employee emp = modelMapper.map(employeDto, Employee.class);		
		emp = employeService.saveEmployee(emp);
		employeDto = modelMapper.map(emp, EmployeDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeDto);
	}
	  
	@GetMapping("/listeDesEmployes")
	public Object employesList() {
		List<Employee> l = employeService.getAllEmployee();
		Type listType = new TypeToken<List<EmployeDto>>(){}.getType();
		List<EmployeDto> employeDtos = modelMapper.map(l, listType);
		return ResponseEntity.status(HttpStatus.OK).body(employeDtos);
	}
	
	
	
	@DeleteMapping("/supprimerEmploye/{matricule}")
	public Object Delete(@PathVariable("matricule") Long matricule) {
		employeService.deleteEmployee(matricule);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/trouverEmploye/{matricule}")
	public Object findOneEmploye(@PathVariable("matricule") long matricule) {
		Employee emp = employeService.getEmployee(matricule);
		EmployeDto employeeDto = modelMapper.map( emp,  EmployeDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
	}

	
	@PutMapping("/modifierEmploye/{matricule}")
    public Object updateEmployee(@Valid @RequestBody EmployeDto employeeDto, @PathVariable("matricule") Long matricule) {
		Employee employee = employeService.getEmployee(matricule);
        employee = modelMapper.map(employeeDto, Employee.class);
        employee = employeService.updateEmployee(matricule, employee);
        employeeDto = modelMapper.map(employee, EmployeDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDto);
    }
	
	@GetMapping("/employees/{matricule}/contrats")
    public Object retrieveContrat(@PathVariable("matricule") Long matricule) {
        Employee employee = employeService.getEmployee(matricule);
        List<Contrat> contrats = contratService.getContratEmploye(employee);
        Type listType = new TypeToken<List<ContratDto>>() {
        }.getType();
        List<ContratDto> contratDtos = modelMapper.map(contrats, listType);
        return ResponseEntity.status(HttpStatus.OK).body(contratDtos);
    }

}
