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
import com.example.demo.model.entities.Enfant;
import com.example.demo.rest.dto.EnfantDto;
import com.example.demo.services.EnfantService;
import com.example.demo.services.EmployeService;




@CrossOrigin("*")
@RestController()
public class EnfantController {

	@Autowired
	private EnfantService enfantService ;
	
	@Autowired
    private EmployeService employeeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	   @PostMapping("/Employee/{idEmploye}/Enfants")
	    public Object addEnfantEmployee(@PathVariable("idEmploye") Long idEmploye, @Valid @RequestBody EnfantDto enfantDto) {
	        Employee employee = employeeService.getEmployee(idEmploye);
	        Enfant enfant = modelMapper.map(enfantDto, Enfant.class);
	        enfant = enfantService.saveEnfantEmployee(enfant, employee);
	        enfantDto = modelMapper.map(enfant, EnfantDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(enfantDto);
	    }
	
	 @GetMapping("/Employee/{idEmploye}/Enfants")
	    public Object EnfantsEmployeeList(@PathVariable("idEmploye") Long idEmploye) {
	        List<Enfant> enfants = enfantService.getAllEmployeeEnfant(idEmploye);
	        Type listType = new TypeToken<List<EnfantDto>>() {
	        }.getType();
	        List<EnfantDto> EnfantDtos = modelMapper.map(enfants, listType);
	        return ResponseEntity.status(HttpStatus.OK).body(EnfantDtos);
	    }
	
	@PutMapping("/Employee/{idEmploye}/Enfants/{id}")
    public Object updateEnfantEmployee(@Valid @RequestBody EnfantDto enfantDto, @PathVariable("id") Long id, @PathVariable("idEmploye") Long idEmploye) {
        Employee Employee = employeeService.getEmployee(idEmploye);
        Enfant enfant = modelMapper.map(enfantDto, Enfant.class);
        enfant = enfantService.updateEnfantEmployee(id, enfant, Employee);
        enfantDto = modelMapper.map(enfant, EnfantDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(enfantDto);
    }
	
	
	@DeleteMapping("/supprimerEnfant/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		enfantService.deleteEnfant(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}


}
