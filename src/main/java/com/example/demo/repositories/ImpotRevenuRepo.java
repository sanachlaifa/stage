package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.ImpotRevenu;


@Repository
public interface ImpotRevenuRepo extends JpaRepository <ImpotRevenu, Long> {
	List<ImpotRevenu> findByContrat(Contrat contrat);
}