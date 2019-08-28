package com.example.demo.model.entities;

import java.io.Serializable;


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
public class ImpotRevenu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idImpotRev ;
	private Double borneSup ;
	private Double borneInf ;
	private Double taux ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name ="CONTRAT_ID")
	 private Contrat contrat;
}
