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
import com.example.demo.model.entities.Parametres;
import com.example.demo.rest.dto.ParametreDto;

import com.example.demo.services.ContratService;
import com.example.demo.services.ParametresService;


@CrossOrigin("*")
@RestController()
public class ParametreController {
	@Autowired
	private ParametresService parametreService ;
	
	@Autowired
    private ContratService contratService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	  @PostMapping("/contrat/{idC}/parametres")
	    public Object addParametreContrat(@PathVariable("idC") Long idC, @Valid @RequestBody ParametreDto parametreDto) {
	        Contrat contrat = contratService.getContrat(idC);
	        Parametres parametres = modelMapper.map( parametreDto, Parametres.class);
	        parametres = parametreService.saveParametresContrat(parametres, contrat);
	        parametreDto = modelMapper.map(parametres, ParametreDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(parametreDto);
	    }
	
	 @GetMapping("/contrat/{idC}/parametres")
	    public Object ParametressContratList(@PathVariable("idC") Long idC) {
	        List<Parametres> parametres =parametreService.getAllContratParametres(idC);
	        Type listType = new TypeToken<List< ParametreDto>>() {
	        }.getType();
	        List< ParametreDto>  parametreDtos = modelMapper.map(parametres, listType);
	        return ResponseEntity.status(HttpStatus.OK).body( parametreDtos);
	    }
	
	@PutMapping("/contrat/{idC}/parametres/{id}")
  public Object updateParametresContrat(@Valid @RequestBody  ParametreDto  parametreDto, @PathVariable("id") Long id, @PathVariable("idC") Long idC) {
      Contrat contrat = contratService.getContrat(idC);
      Parametres parametres = modelMapper.map( parametreDto, Parametres.class);
      parametres = parametreService.updateParametresContrat(id, parametres, contrat);
       parametreDto = modelMapper.map(parametres,  ParametreDto.class);
      return ResponseEntity.status(HttpStatus.CREATED).body( parametreDto);
  }
	
	
	@DeleteMapping("/supParametresrParametre/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		parametreService.deleteParametre(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}
