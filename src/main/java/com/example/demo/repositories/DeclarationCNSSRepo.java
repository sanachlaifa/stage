package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.DeclarationCNSS;

@Repository
public interface DeclarationCNSSRepo extends JpaRepository <DeclarationCNSS, Long> {

}
