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

import com.example.demo.entities.Contrat;
import com.example.demo.rest.dto.ContratDto;
import com.example.demo.services.ContratService;

@CrossOrigin("*")
@RestController("/contrats")
public class ContratController {
	
	@Autowired
	private ContratService contratService;
	
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/ajouterContrat")
	   public Object addContrat(@Valid @RequestBody ContratDto contratDto, @Valid @RequestBody Long idEmploye) {
        Contrat contrat = modelMapper.map(contratDto, Contrat.class);
        contrat = contratService.saveContrat(contrat, idEmploye);
        contratDto = modelMapper.map(contrat, ContratDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(contratDto);
    }
	
	@DeleteMapping("/supprimerContrat/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		contratService.deleteContrat(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}	
	
	@GetMapping("/listeDesContrats")
	public Object contratsList() {
		List<Contrat> l = contratService.getAllContrat();
		Type listType = new TypeToken<List<ContratDto>>(){}.getType();
		List<ContratDto> contratDtos = modelMapper.map(l, listType);
		return ResponseEntity.status(HttpStatus.OK).body(contratDtos);
	}
	
	 @PutMapping("/modifierContrat/{id}")
     public Object updateContrat(@Valid @RequestBody ContratDto contratDto, @PathVariable Long id, Long idEmploye) {
         Contrat contrat = modelMapper.map(contratDto, Contrat.class);
         contrat = contratService.updateContrat(id, contrat, idEmploye);
         contratDto = modelMapper.map(contrat, ContratDto.class);
         return ResponseEntity.status(HttpStatus.CREATED).body(contratDto);
     }
	 
	 @GetMapping("/trouverContrat/{id}")
     public Object retrieveContrat(@PathVariable long id) {
         Contrat contrat = contratService.getContrat(id);
         ContratDto contratDto = modelMapper.map(contrat, ContratDto.class);
         return ResponseEntity.status(HttpStatus.OK).body(contratDto);
     }
	
}

