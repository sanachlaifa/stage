package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.Prime;
@Repository
public interface PrimeRepo extends CrudRepository<Prime, Long>{
    List<Prime> findByContrat(Contrat contrat);
}
