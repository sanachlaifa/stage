package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Employee;
import com.example.demo.model.entities.Presence;

@Repository
public interface PresenceRepo extends JpaRepository < Presence, Long> {
	List<Presence> findByEmployee(Employee employee);
}