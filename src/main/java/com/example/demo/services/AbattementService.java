package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Abattement;


public interface AbattementService {
       Abattement getAbattement (Long id);
       void deleteAbattement (Long id);
       List<Abattement> getAllAbattement();       
       Abattement saveAbattement(Abattement abattement);
       Abattement updateAbattement(long id, Abattement abattement);
}
