package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entities.Presence;

@Repository
public interface PresenceRepo extends JpaRepository < Presence, Long> {

}