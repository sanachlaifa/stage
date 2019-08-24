package com.example.demo.services;
import java.util.List;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.FichePaie;
public interface FichePaieService {
    
    FichePaie getFichePaie(Long id);
    
    List<FichePaie> getAllContratFichePaie(Long id);
    
    FichePaie saveFichePaieContrat(FichePaie fiche, Contrat contrat);
    
    void deleteFichePaie(Long id);
    
    FichePaie updateFichePaieContrat(Long id, FichePaie fiche, Contrat contrat);
}

