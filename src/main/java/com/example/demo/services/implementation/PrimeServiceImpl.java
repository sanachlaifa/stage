package com.example.demo.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.Prime;
import com.example.demo.repositories.PrimeRepo;
import com.example.demo.services.ContratService;
import com.example.demo.services.PrimeService;


@Service
public class PrimeServiceImpl implements PrimeService {

	
	
	@Autowired
    private ContratService contratService;
	@Autowired
	private PrimeRepo primeRepository ;
	@Override
	public Prime getPrime(Long id) {
		 Prime prime = primeRepository.findById(id).get();
	        if (prime == null) {
	            System.out.println("erreur get");
	        }
	        return prime;
	}
	@Override
	public List<Prime> getAllContratPrime(Long id) {
		Contrat contrat = contratService.getContrat(id);
        return (List<Prime>) primeRepository.findByContrat(contrat);
	}
	
	 @Transactional
	@Override
	public Prime savePrimeContrat(Prime prime, Contrat contrat) {
		 prime.setContrat(contrat);
	        return primeRepository.save(prime);
	}
	
	 @Transactional
	@Override
	public void deletePrime(Long id) {
		 try {
	            primeRepository.deleteById(id);
	        } catch (EmptyResultDataAccessException e) {
	            System.out.println("erreur delete");
	        }	
	}
	
	 @Transactional
	@Override
	public Prime updatePrimeContrat(Long id, Prime prime, Contrat contrat) {
		   getPrime(id);
	        prime.setIdPrime(id);
	        prime.setContrat(contrat);
	        return savePrimeContrat(prime, contrat);
	} ;


	
}



   