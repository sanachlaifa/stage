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
import com.example.demo.model.entities.ImpotRevenu;
import com.example.demo.rest.dto.ImpotDto;
import com.example.demo.services.ContratService;
import com.example.demo.services.ImpotService;


@CrossOrigin("*")
@RestController()
public class ImpotController {
	@Autowired
	private ImpotService impotService ;
	
	@Autowired
    private ContratService contratService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/contrat/{idC}/impots")
    public Object addImpotContrat(@PathVariable("idC") Long idC, @Valid @RequestBody ImpotDto impotDto) {
        Contrat contrat = contratService.getContrat(idC);
        ImpotRevenu impot = modelMapper.map(impotDto, ImpotRevenu.class);
        impot = impotService.saveImpotContrat(impot, contrat);
        impotDto = modelMapper.map(impot, ImpotDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(impotDto);
    }
	
	@GetMapping("/contrat/{idC}/impots")
    public Object ImpotsContratList(@PathVariable("idC") Long idC) {
        List<ImpotRevenu> primes = impotService.getAllContratImpot(idC);
        Type listType = new TypeToken<List<ImpotDto>>() {
        }.getType();
        List<ImpotDto> impotDtos = modelMapper.map(primes, listType);
        return ResponseEntity.status(HttpStatus.OK).body(impotDtos);
    }
	
	@PutMapping("/contrat/{idC}/impots/{id}")
    public Object updateImpotContrat(@Valid @RequestBody ImpotDto impotDto, @PathVariable("id") Long id, @PathVariable("idC") Long idC) {
        Contrat contrat = contratService.getContrat(idC);
        ImpotRevenu impot = modelMapper.map(impotDto, ImpotRevenu.class);
        impot = impotService.updateImpotContrat(id, impot, contrat);
        impotDto = modelMapper.map(impot, ImpotDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(impotDto);
    }
	

	@DeleteMapping("/supprimerImpot/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		impotService.deleteImpot(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}
