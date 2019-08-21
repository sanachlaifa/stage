package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Presence;

@Repository
public interface PresenceRepo extends JpaRepository < Presence, Long> {
	List<Presence> findByEmployee(Employee employee);
}