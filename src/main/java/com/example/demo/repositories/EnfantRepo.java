package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Employee;
import com.example.demo.model.entities.Enfant;

@Repository
public interface EnfantRepo extends JpaRepository <Enfant, Long> {
	List<Enfant> findByEmployee(Employee employee);

}
