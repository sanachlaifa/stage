package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Contrat;
import com.example.demo.model.entities.Employee;

@Repository
public interface ContratRepo extends JpaRepository <Contrat , Long> {
	List<Contrat> findByEmployee(Employee employee);
}
