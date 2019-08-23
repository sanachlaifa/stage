package com.example.demo.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.entities.Categorie;
import com.example.demo.repositories.CategorieRepo;
import com.example.demo.services.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieRepo categorieRepository;
    
    @Override
    public Categorie getCategorie(Long id) {
        Categorie Categorie = categorieRepository.findById(id).get();
        if (Categorie == null) {
            System.out.println("erreur get");
        }
        return Categorie;
    }
    @Transactional
    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }
    
    @Transactional
    @Override
    public Categorie updateCategorie(@PathVariable long id, Categorie categorie) {
        getCategorie(id);
        categorie.setIdCat(id);
        return saveCategorie(categorie);
    }
    
    @Override
    public List<Categorie>  getAllCategorie() {
        return (List<Categorie>) categorieRepository.findAll();
    }
    
    @Transactional
    @Override
    public void deleteCategorie(Long id) {
        try {
            categorieRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("erreur delete");
        }
    }
}



