package com.example.demo.services;
import java.util.List;

import com.example.demo.entities.Prime;
public interface PrimeService {
	 public Prime trouverPrime (Long p) ;
	 public Prime AjouterPrime (Prime p);
	 public Prime modifierPrime (Long p , float val);
	 public List<Prime> consulterPrimes ();
	 public void supprimerPrime (Long p);
	 public List<Prime>  chercherPrime (String criteria);
}
