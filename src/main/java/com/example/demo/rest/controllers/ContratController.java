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

import com.example.demo.model.entities.Employee;
import com.example.demo.model.entities.Contrat;
import com.example.demo.rest.dto.ContratDto;
import com.example.demo.services.ContratService;
import com.example.demo.services.EmployeService;




@CrossOrigin("*")
@RestController()
public class ContratController {

	@Autowired
	private ContratService contratService ;
	
	@Autowired
    private EmployeService employeeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	   @PostMapping("/Employee/{idEmploye}/Contrats")
	    public Object addContratEmployee(@PathVariable("idEmploye") Long idEmploye, @Valid @RequestBody ContratDto contratDto) {
	        Employee employee = employeeService.getEmployee(idEmploye);
	        Contrat contrat = modelMapper.map(contratDto, Contrat.class);
	        contrat = contratService.saveContratEmployee(contrat, employee);
	        contratDto = modelMapper.map(contrat, ContratDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(contratDto);
	    }
	
	 @GetMapping("/Employee/{idEmploye}/Contrats")
	    public Object ContratsEmployeeList(@PathVariable("idEmploye") Long idEmploye) {
	        List<Contrat> contrats = contratService.getAllEmployeeContrat(idEmploye);
	        Type listType = new TypeToken<List<ContratDto>>() {
	        }.getType();
	        List<ContratDto> ContratDtos = modelMapper.map(contrats, listType);
	        return ResponseEntity.status(HttpStatus.OK).body(ContratDtos);
	    }
	
	@PutMapping("/Employee/{idEmploye}/Contrats/{id}")
    public Object updateContratEmployee(@Valid @RequestBody ContratDto contratDto, @PathVariable("id") Long id, @PathVariable("idEmploye") Long idEmploye) {
        Employee Employee = employeeService.getEmployee(idEmploye);
        Contrat contrat = modelMapper.map(contratDto, Contrat.class);
        contrat = contratService.updateContratEmployee(id, contrat, Employee);
        contratDto = modelMapper.map(contrat, ContratDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(contratDto);
    }
	
	
	@DeleteMapping("/supprimerContrat/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		contratService.deleteContrat(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}


}
