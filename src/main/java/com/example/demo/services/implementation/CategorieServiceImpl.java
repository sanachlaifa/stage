package com.example.demo.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Categorie;
import com.example.demo.repositories.CategorieRepo;
import com.example.demo.services.AbattementService;
import com.example.demo.services.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieRepo categorieRepo ;
	
	@Autowired
	private AbattementService abattementService ;
	
	@Override
	public Categorie getCategorie(Long id) {
		Categorie categorie = categorieRepo.findById(id).get();
		if(categorie == null) {
			System.out.println("erreur get");
		} 
		return categorie;
	}

	@Override
	public List<Categorie> getAllAbattementCategorie(Long id) {
		return (List<Categorie>) categorieRepo.findAll();
	}

	@Transactional
	@Override
	public Categorie saveCategorieAbattement(Categorie categorie, Long idAbattement) {
		 if(abattementService.getAbattement(idAbattement) == null) {
	            System.out.println("erreur get abattement");
	        } else {
	           
	            categorie.setAbattement(abattementService.getAbattement(idAbattement));
	            return categorieRepo.save(categorie);    
	        }
	        return null;
	}

	@Transactional
	@Override
	public void deleteCategorie(Long id) {
		try {
			categorieRepo.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			System.out.println("erreur delete");
		}
		
	}

	@Transactional
	@Override
	public Categorie updateCategorieAbattement(Long id, Categorie categorie, Long idAbattement) {
		getCategorie(id);
        categorie.setIdCat(id);
        return saveCategorieAbattement(categorie, idAbattement);
	}

}
