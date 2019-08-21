package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Abattement implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAbat ;
	private float valeur ;
	private Date dateAbat ;

	
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name ="CONTRAT_ID")
	 private Contrat contrat;
	
	 @OneToMany(mappedBy ="abattement", cascade= {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	    private Set<Categorie> categories;
}
