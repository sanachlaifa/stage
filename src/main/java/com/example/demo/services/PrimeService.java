package com.example.demo.services;
import java.util.List;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Prime;
public interface PrimeService {
    
    Prime getPrime(Long id);
    
    List<Prime> getAllContratPrime(Long id);
    
    Prime savePrimeContrat(Prime prime, Contrat contrat);
    
    void deletePrime(Long id);
    
    Prime updatePrimeContrat(Long id, Prime prime, Contrat contrat);
}

