package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Abattement;

@Repository
public interface AbattementRepo extends JpaRepository <Abattement, Long> {

}
