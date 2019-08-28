package com.example.demo.model.entities;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.model.enumeration.Charge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parametres  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long idPar ;
	@Enumerated(EnumType.STRING)
 private Charge nomPar ;
 private float valPar ;


 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name ="CONTRAT_ID")
 private Contrat contrat;

}
