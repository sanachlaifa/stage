package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Abattement;
import com.example.demo.entities.Contrat;


@Repository
public interface AbattementRepo extends JpaRepository <Abattement, Long> {
	List<Abattement> findByContrat(Contrat contrat);
}
