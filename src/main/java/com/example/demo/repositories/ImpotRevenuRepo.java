package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ImpotRevenu;

@Repository
public interface ImpotRevenuRepo extends JpaRepository <ImpotRevenu, Long> {

}