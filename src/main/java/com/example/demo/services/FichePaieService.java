package com.example.demo.services;

import java.util.List;

import com.example.demo.model.entities.FichePaie;

public interface FichePaieService {
	FichePaie getFichePaie(Long id);
    void deleteFichePaie(Long id); 
    List<FichePaie> getAllFichePaie();
    
    //employee
    FichePaie saveFichePaie(FichePaie fiche , Long idEmploye , Long idContrat);
    FichePaie updateFichePaie(long id, FichePaie fiche, Long idEmploye , Long idContrat);
    List<FichePaie> getFichePaieEmploye(Long id);
}
