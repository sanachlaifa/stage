package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.ImpotRevenu;


@Repository
public interface ImpotRevenuRepo extends JpaRepository <ImpotRevenu, Long> {
	List<ImpotRevenu> findByContrat(Contrat contrat);
}