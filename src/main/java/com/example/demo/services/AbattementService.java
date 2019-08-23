package com.example.demo.services;

import java.util.List;

import com.example.demo.model.entities.Abattement;
import com.example.demo.model.entities.Contrat;




public interface AbattementService {
       Abattement getAbattement (Long id);
       void deleteAbattement (Long id);
         
     
       
       // contrat 
       List<Abattement> getAllContratAbattement(Long id);
       Abattement saveAbattementContrat(Abattement abattement, Contrat contrat);
       Abattement updateAbattementContrat(Long id, Abattement abattement, Contrat contrat);
}


