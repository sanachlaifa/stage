package com.example.demo.rest.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employé;
import com.example.demo.rest.dto.EmployeDto;
import com.example.demo.services.EmployeService;

@RestController("/employes")
public class EmployeController {
	@Autowired
	private EmployeService employeService ;
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/ajouterEmploye")
	public Object addEmploye(@Valid @RequestBody EmployeDto employeDto) {
		Employé emp = modelMapper.map(employeDto, Employé.class);		
		emp = employeService.AjouterEmployé(emp);
		employeDto = modelMapper.map(emp, EmployeDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeDto);
	}
	
	@GetMapping("/listeDesEmployes")
	public Object employesList() {
		List<Employé> l = employeService.consulterEmployés();
		Type listType = new TypeToken<List<EmployeDto>>(){}.getType();
		List<EmployeDto> employeDtos = modelMapper.map(l, listType);
		return ResponseEntity.status(HttpStatus.OK).body(employeDtos);
	}
	
	
	
	@GetMapping("/chercherEmploye/{id}")
	public Object findEmploye(@PathVariable String id) {
		List<Employé> l = employeService.chercherEmployé(id);
		Type listType = new TypeToken<List<EmployeDto>>(){}.getType();
		List<EmployeDto> employeDto = modelMapper.map(l, listType);
		return ResponseEntity.status(HttpStatus.OK).body(employeDto );
	}
	
	@DeleteMapping("/supprimerEmploye/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		employeService.supprimerEmployé(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@GetMapping("/trouverEmploye/{id}")
	public Object findOneEmploye(@PathVariable long id) {
		Employé emp = employeService.trouverEmployé(id);
		EmployeDto primeDto = modelMapper.map( emp,  EmployeDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(primeDto);
	}

}
