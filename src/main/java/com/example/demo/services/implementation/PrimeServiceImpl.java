package com.example.demo.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Prime;

import com.example.demo.repositories.PrimeRepo;
import com.example.demo.services.PrimeService;

@Service
public class PrimeServiceImpl implements PrimeService {

	@Autowired
	private PrimeRepo primeRep ;
	
	@Override
	@Transactional
	public Prime AjouterPrime(Prime p) {
		return primeRep.save(p);
		
	}

	@Override
	@Transactional
	public Prime modifierPrime(Long p , float val) {
		Prime prime = trouverPrime(p);
        prime.setValeurPrime(val);
		return primeRep.save(prime) ;
	}

	

	@Override
	@Transactional
	public void supprimerPrime(Long p) {
		Prime prime = trouverPrime(p);
		primeRep.delete(prime);
		
	}

	@Override
	public List<Prime> chercherPrime(String c) {
		List <Prime> l = new ArrayList <Prime> ();
		List <Prime> lp = consulterPrimes();
		for (Prime prime : lp) {
			if(prime.getNomPrime().contains(c)) {
				l.add(prime);
			}
		}
		return l;
	}

	@Override
	public List<Prime> consulterPrimes() {
		return primeRep.findAll() ;
	}

	@Override
	public Prime trouverPrime(Long p) {
		
		return primeRep.getOne(p);
	}
	
}
