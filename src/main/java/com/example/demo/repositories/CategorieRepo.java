package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Abattement;
import com.example.demo.entities.Categorie;



@Repository
public interface CategorieRepo extends JpaRepository <Categorie , Long>{
	List<Categorie> findByAbattement(Abattement abattement);
}
