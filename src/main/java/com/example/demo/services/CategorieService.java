package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Abattement;
import com.example.demo.entities.Categorie;


public interface CategorieService {
	
	    Categorie getCategorie(Long id);
	    
	    List<Categorie> getAllAbattementCategorie(Long id);
	    
	    Categorie saveCategorieAbattement(Categorie categorie, Long idAbattement);
	    
	    void deleteCategorie(Long id);
	    
	    Categorie updateCategorieAbattement(Long id, Categorie categorie, Long idAbattement);

}
