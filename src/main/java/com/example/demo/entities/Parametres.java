package com.example.demo.entities;



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
public class Parametres {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long idAutre ;
 private String nomPar ;
 private float valPar ;


 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name ="CONTRAT_ID")
 private Contrat contrat;

}
