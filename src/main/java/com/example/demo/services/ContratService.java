package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Contrat;

public interface ContratService {
	 public Contrat AjouterContrat (Contrat c);
	 public void supprimerContrat (Long id);
	 public List<Contrat> consulterContrats ();

}
