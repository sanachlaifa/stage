package com.example.demo.model.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.model.enumeration.Etat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enfant  implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	   @GeneratedValue(strategy= GenerationType.IDENTITY)
	   @Column(name= "ID", nullable=false)
	   private Long id;
	   private Etat etatEnfant;
	   @ManyToOne(fetch = FetchType.LAZY)
		 @JoinColumn(name ="EMPLOYEE_MATRICULE")
		 private Employee employee;

}
