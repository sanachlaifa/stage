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
import com.example.demo.model.entities.Prime;
import com.example.demo.rest.dto.PrimeDto;
import com.example.demo.services.ContratService;
import com.example.demo.services.PrimeService;




@CrossOrigin("*")
@RestController()
public class PrimeController {

	@Autowired
	private PrimeService primeService ;
	
	@Autowired
    private ContratService contratService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	   @PostMapping("/contrat/{idC}/primes")
	    public Object addPrimeContrat(@PathVariable("idC") Long idC, @Valid @RequestBody PrimeDto primeDto) {
	        Contrat contrat = contratService.getContrat(idC);
	        Prime prime = modelMapper.map(primeDto, Prime.class);
	        prime = primeService.savePrimeContrat(prime, contrat);
	        primeDto = modelMapper.map(prime, PrimeDto.class);
	        return ResponseEntity.status(HttpStatus.CREATED).body(primeDto);
	    }
	
	 @GetMapping("/contrat/{idC}/primes")
	    public Object PrimesContratList(@PathVariable("idC") Long idC) {
	        List<Prime> primes = primeService.getAllContratPrime(idC);
	        Type listType = new TypeToken<List<PrimeDto>>() {
	        }.getType();
	        List<PrimeDto> primeDtos = modelMapper.map(primes, listType);
	        return ResponseEntity.status(HttpStatus.OK).body(primeDtos);
	    }
	
	@PutMapping("/contrat/{idC}/primes/{id}")
    public Object updatePrimeContrat(@Valid @RequestBody PrimeDto primeDto, @PathVariable("id") Long id, @PathVariable("idC") Long idC) {
        Contrat contrat = contratService.getContrat(idC);
        Prime prime = modelMapper.map(primeDto, Prime.class);
        prime = primeService.updatePrimeContrat(id, prime, contrat);
        primeDto = modelMapper.map(prime, PrimeDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(primeDto);
    }
	
	
	@DeleteMapping("/supprimerPrime/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		primeService.deletePrime(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}


}
