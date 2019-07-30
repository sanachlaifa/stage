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
public class FichePaie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFiche ;
    private String urlFiche ;
    public String getUrlFiche() {
		return urlFiche;
	}

	public void setUrlFiche(String urlFiche) {
		this.urlFiche = urlFiche;
	}

	@Temporal(TemporalType.DATE)
	private Date dateCreation ;

	public Long getIdFiche() {
		return idFiche;
	}

	public void setIdFiche(Long idFiche) {
		this.idFiche = idFiche;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

}
