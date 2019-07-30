package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Contrat;

@Repository
public interface ContratRepo extends JpaRepository <Contrat , Long> {

}
