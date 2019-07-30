package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImpotRevenu implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idImpotRev ;
	private long borneSup ;
	public Long getIdImpotRev() {
		return idImpotRev;
	}
	public void setIdImpotRev(Long idImpotRev) {
		this.idImpotRev = idImpotRev;
	}
	public long getBorneSup() {
		return borneSup;
	}
	public void setBorneSup(long borneSup) {
		this.borneSup = borneSup;
	}
	public long getBorneInf() {
		return borneInf;
	}
	public void setBorneInf(long borneInf) {
		this.borneInf = borneInf;
	}
	public float getTaux() {
		return taux;
	}
	public void setTaux(float taux) {
		this.taux = taux;
	}
	private long borneInf ;
	private float taux ;
}
