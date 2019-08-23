package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.Employee;
import com.example.demo.model.entities.FichePaie;


@Repository
public interface FichePaieRepo extends JpaRepository<FichePaie, Long>{
	List<FichePaie> findByEmployee(Employee employee);
	List<FichePaie> findByContrat(Contrat contrat);
}
