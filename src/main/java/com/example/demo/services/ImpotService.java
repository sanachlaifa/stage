package com.example.demo.services;

import java.util.List;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.ImpotRevenu;

public interface ImpotService {
	  ImpotRevenu getImpot (Long id);
       void deleteImpot (Long id);
         
     
       
       // contrat 
       List<ImpotRevenu> getAllContratImpot(Long id);
       ImpotRevenu saveImpotContrat(ImpotRevenu impot, Contrat contrat);
       ImpotRevenu updateImpotContrat(Long id, ImpotRevenu impot, Contrat contrat);
}
