package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Prime;

@Repository
public interface PrimeRepo extends JpaRepository<Prime , Long> {

}
