package com.example.demo.services;

import java.util.List;

import com.example.demo.model.entities.Employee;
import com.example.demo.model.entities.Presence;

public interface PresenceService {
	Presence getPresence(Long id);
    void deletePresence(Long id); 
    List<Presence> getAllPresence();
    
    //employee
    Presence savePresenceEmploye(Presence presence, Employee employe);  
    Presence updatePresenceEmploye(long id, Presence presence, Employee employe);
    List<Presence> getPresenceEmploye(Long id);
}
