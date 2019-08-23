package com.example.demo.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
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
public class Presence implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPres ;
	private Long nbreJoursPres ;
	private String mois ;
	
	private Long année ;
	

	private Long nbreHeuresPres ;
	private Long nbreHeuresSupp ;
	@ManyToOne
	@JoinColumn(name ="employee.MATRICULE")
	private Employee employee ;

}
