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
import com.example.demo.model.entities.FichePaie;
import com.example.demo.rest.dto.FichePaieDto;
import com.example.demo.rest.dto.ContratDto;

import com.example.demo.services.ContratService;
import com.example.demo.services.FichePaieService;




@CrossOrigin("*")
@RestController()
public class FichePaieController {

	@Autowired
	private FichePaieService ficheService ;
	
	@Autowired
    private ContratService contratService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	   @PostMapping("/contrat/{idC}/fichesPaie")
	    public Object addFichePaieContrat(@PathVariable("idC") Long idC, @Valid @RequestBody FichePaieDto fichesPaieDto) {
	        Contrat contrat = contratService.getContrat(idC);
	        FichePaie fichesPaie = modelMapper.map(fichesPaieDto, FichePaie.class);
	        fichesPaie = ficheService.saveFichePaieContrat(fichesPaie, contrat);
	        fichesPaieDto = modelMapper.map(fichesPaie, FichePaieDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(fichesPaieDto);
	    }
	
	   @GetMapping("/calcul/{id}")
		public Object findOneEmploye(@PathVariable("id") long id) {
			FichePaie fiche = ficheService.getFichePaie(id);
			FichePaieDto ficheDto = modelMapper.map( fiche,  FichePaieDto.class);
			ficheDto.setNet_A_payer(ficheService.netApayer(id));
			return ResponseEntity.status(HttpStatus.OK).body(ficheDto);
		}
	   
	 @GetMapping("/contrat/{idC}/fichesPaie")
	    public Object FichePaiesContratList(@PathVariable("idC") Long idC) {
	        List<FichePaie> fichesPaie = ficheService.getAllContratFichePaie(idC);
	        Type listType = new TypeToken<List<FichePaieDto>>() {
	        }.getType();
	        List<FichePaieDto> fichesPaieDtos = modelMapper.map(fichesPaie, listType);
	        return ResponseEntity.status(HttpStatus.OK).body(fichesPaieDtos);
	    }
	 
	 @GetMapping("/getContrat/{idF}")
	    public Object FichePaiesContrat(@PathVariable("idF") Long idF) {
		 Contrat  c = ficheService.getContrat(ficheService.getFichePaie(idF)); 
	        ContratDto contratDto = modelMapper.map( c,  ContratDto.class);
	        return ResponseEntity.status(HttpStatus.OK).body(contratDto);
	    }
	
	@PutMapping("/contrat/{idC}/fichesPaie/{id}")
    public Object updateFichePaieContrat(@Valid @RequestBody FichePaieDto fichesPaieDto, @PathVariable("id") Long id, @PathVariable("idC") Long idC) {
        Contrat contrat = contratService.getContrat(idC);
        FichePaie fichesPaie = modelMapper.map(fichesPaieDto, FichePaie.class);
        fichesPaie = ficheService.updateFichePaieContrat(id, fichesPaie, contrat);
        fichesPaieDto = modelMapper.map(fichesPaie, FichePaieDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(fichesPaieDto);
    }
	
	
	@DeleteMapping("/supprimerFichePaie/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		ficheService.deleteFichePaie(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
