package com.example.demo.services;

import java.util.List;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.Parametres;

public interface ParametresService {
	Parametres getParametre (Long id);
     void deleteParametre (Long id);
       
   
     
     // contrat 
     List<Parametres> getAllContratParametres(Long id);
     Parametres saveParametresContrat(Parametres parm, Contrat contrat);
     Parametres updateParametresContrat(Long id, Parametres parm, Contrat contrat);
}
