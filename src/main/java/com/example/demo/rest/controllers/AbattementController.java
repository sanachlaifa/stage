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

import com.example.demo.model.entities.Abattement;
import com.example.demo.model.entities.Contrat;
import com.example.demo.rest.dto.AbattementDto;
import com.example.demo.services.AbattementService;
import com.example.demo.services.ContratService;


@CrossOrigin("*")
@RestController()
public class AbattementController {
	@Autowired
	private AbattementService abattementService ;
	
	@Autowired
    private ContratService contratService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/contrat/{idC}/abattements")
    public Object addAbattementContrat(@PathVariable("idC") Long idC, @Valid @RequestBody AbattementDto abattementDto) {
        Contrat contrat = contratService.getContrat(idC);
        Abattement abattement = modelMapper.map(abattementDto, Abattement.class);
        abattement = abattementService.saveAbattementContrat(abattement, contrat);
        abattementDto = modelMapper.map(abattement, AbattementDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(abattementDto);
    }
	
	@GetMapping("/contrat/{idC}/abattements")
    public Object  AbattementsContratList(@PathVariable("idC") Long idC) {
        List< Abattement> abattements = abattementService.getAllContratAbattement(idC);
        Type listType = new TypeToken<List<AbattementDto>>() {
        }.getType();
        List< AbattementDto> abattementDtos = modelMapper.map(abattements, listType);
        return ResponseEntity.status(HttpStatus.OK).body(abattementDtos);
    }
	@PutMapping("/contrat/{idC}/abattements/{id}")
    public Object updateAbattementContrat(@Valid @RequestBody AbattementDto abattementDto, @PathVariable("id") Long id, @PathVariable("idC") Long idC) {
        Contrat contrat = contratService.getContrat(idC);
        Abattement abattement = modelMapper.map(abattementDto, Abattement.class);
        abattement = abattementService.updateAbattementContrat(id,abattement, contrat);
        abattementDto = modelMapper.map(abattement, AbattementDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(abattementDto);
    }
	@DeleteMapping("/supprimerAbattement/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		abattementService.deleteAbattement(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}
