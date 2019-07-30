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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Prime;
import com.example.demo.rest.dto.PrimeDto;
import com.example.demo.services.PrimeService;





@RestController("/primes")
public class PrimeController {

	@Autowired
	private PrimeService primeService ;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/liste")
	public Object primesList() {
		List<Prime> primes = primeService.consulterPrimes();
		Type listType = new TypeToken<List<PrimeDto>>(){}.getType();
		List<PrimeDto> primeDtos = modelMapper.map(primes, listType);
		return ResponseEntity.status(HttpStatus.OK).body(primeDtos);
	}
	
	@GetMapping("/{id}")
	public Object findOnePrime(@PathVariable long id) {
		Prime prime = primeService.trouverPrime(id);
		PrimeDto primeDto = modelMapper.map( prime,  PrimeDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(primeDto);
	}
	
	@PostMapping()
	public Object addPrime(@Valid @RequestBody PrimeDto primeDto) {
		Prime prime = modelMapper.map(primeDto, Prime.class);
		
		prime = primeService.AjouterPrime(prime);

		primeDto = modelMapper.map(prime, PrimeDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(primeDto);
	}
	
	@GetMapping("/find/{id}")
	public Object findPrime(@PathVariable String c) {
		List<Prime> l = primeService.chercherPrime(c);
		Type listType = new TypeToken<List<PrimeDto>>(){}.getType();
		List<PrimeDto> primeDto = modelMapper.map(l, listType);
		return ResponseEntity.status(HttpStatus.OK).body(primeDto );
	}
	
	@PatchMapping("/update/{id}")
	public Object updatePrimeValue(@Valid @RequestBody PrimeDto primeDto, @PathVariable long id ) {
		Prime prime = primeService.modifierPrime(id, primeDto.getValeurPrime());
		primeDto = modelMapper.map(prime, PrimeDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(primeDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public Object Delete(@PathVariable("id") Long id) {
		primeService.supprimerPrime(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}

}
