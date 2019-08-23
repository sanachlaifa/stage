package com.example.demo.services;

import java.util.List;

import com.example.demo.model.entities.Abattement;
import com.example.demo.model.entities.Categorie;



public interface CategorieService {
	
	Categorie getCategorie(Long id);
	Categorie saveCategorie(Categorie Categorie);
	List<Categorie> getAllCategorie();
	void deleteCategorie(Long id);
	 Categorie updateCategorie( long id, Categorie Categorie) ;

}
