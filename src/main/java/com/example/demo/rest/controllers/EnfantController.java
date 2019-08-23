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

import com.example.demo.model.entities.Enfant;
import com.example.demo.rest.dto.EnfantDto;
import com.example.demo.services.EnfantService;

@CrossOrigin("*")
@RestController()
public class EnfantController {
	
	@Autowired
	private EnfantService enfantService;
	
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/ajouterEnfant")
	   public Object addEnfant(@Valid @RequestBody EnfantDto enfantDto, @Valid @RequestBody Long idEmploye) {
        Enfant enfant = modelMapper.map(enfantDto, Enfant.class);
        enfant = enfantService.saveEnfant(enfant, idEmploye);
        enfantDto = modelMapper.map(enfant, EnfantDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(enfantDto);
    }
	
	@DeleteMapping("/supprimerEnfant/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		enfantService.deleteEnfant(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}	
	
	@GetMapping("/listeDesEnfants")
	public Object EnfantsList() {
		List<Enfant> l = enfantService.getAllEnfant();
		Type listType = new TypeToken<List<EnfantDto>>(){}.getType();
		List<EnfantDto> enfantDtos = modelMapper.map(l, listType);
		return ResponseEntity.status(HttpStatus.OK).body(enfantDtos);
	}
	
	 @PutMapping("/modifierEnfant/{id}")
     public Object updateEnfant(@Valid @RequestBody EnfantDto enfantDto, @PathVariable Long id, Long idEmploye) {
         Enfant enfant = modelMapper.map(enfantDto, Enfant.class);
         enfant = enfantService.updateEnfant(id, enfant, idEmploye);
         enfantDto = modelMapper.map(enfant, EnfantDto.class);
         return ResponseEntity.status(HttpStatus.CREATED).body(enfantDto);
     }
	 
	 @GetMapping("/trouverEnfant/{id}")
     public Object retrieveEnfant(@PathVariable long id) {
         Enfant Enfant = enfantService.getEnfant(id);
         EnfantDto EnfantDto = modelMapper.map(Enfant, EnfantDto.class);
         return ResponseEntity.status(HttpStatus.OK).body(EnfantDto);
     }
	
}

