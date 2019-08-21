package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prime {
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idPrime ;
	 @Column(name= "VALEUR")
	 private Float valeurPrime ;
	 @Column(name= "NOM")
	 private String nomPrime ;
	 @Column(name= "DATECREATION")
	 private Date dateCreationPrime ;
	 @Column(name= "OPTION")
	 private String option ;
	 @Column(name= "MOISAFF")
	 private String  [] moisAff ;
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name ="CONTRAT_ID")
	 private Contrat contrat;
}
