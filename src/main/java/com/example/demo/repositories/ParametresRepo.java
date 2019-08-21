package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Parametres;


@Repository
public interface ParametresRepo extends JpaRepository <Parametres, Long> {
	List<Parametres> findByContrat(Contrat contrat);
}