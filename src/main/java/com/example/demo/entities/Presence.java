package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Presence implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPres ;
	private Long idSal ;
	private Long nbreJoursPres ;
	private String mois ;
	public Long getIdSal() {
		return idSal;
	}
	public void setIdSal(Long idSal) {
		this.idSal = idSal;
	}
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	public Long getAnnée() {
		return année;
	}
	public void setAnnée(Long année) {
		this.année = année;
	}
	private Long année ;
	public Long getIdPres() {
		return idPres;
	}
	public void setIdPres(Long idPres) {
		this.idPres = idPres;
	}
	public Long getNbreJoursPres() {
		return nbreJoursPres;
	}
	public void setNbreJoursPres(Long nbreJoursPres) {
		this.nbreJoursPres = nbreJoursPres;
	}
	public Long getNbreHeuresPres() {
		return nbreHeuresPres;
	}
	public void setNbreHeuresPres(Long nbreHeuresPres) {
		this.nbreHeuresPres = nbreHeuresPres;
	}
	public Long getNbreHeuresSupp() {
		return nbreHeuresSupp;
	}
	public void setNbreHeuresSupp(Long nbreHeuresSupp) {
		this.nbreHeuresSupp = nbreHeuresSupp;
	}
	private Long nbreHeuresPres ;
	private Long nbreHeuresSupp ;

}
