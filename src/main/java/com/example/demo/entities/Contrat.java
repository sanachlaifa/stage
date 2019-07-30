package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Contrat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idContrat ;
	private String typeContrat ;
	public Long getIdContrat() {
		return idContrat;
	}
	public void setIdContrat(Long idContrat) {
		this.idContrat = idContrat;
	}
	public String getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getTypeSalaire() {
		return typeSalaire;
	}
	public void setTypeSalaire(String typeSalaire) {
		this.typeSalaire = typeSalaire;
	}
	public Float getSalaireBase() {
		return salaireBase;
	}
	public void setSalaireBase(Float salaireBase) {
		this.salaireBase = salaireBase;
	}
	@Temporal(TemporalType.DATE)
	private Date dateDebut ;
	@Temporal(TemporalType.DATE)
	private Date dateFin ;
	private String typeSalaire ;
	private Float salaireBase ;

}
