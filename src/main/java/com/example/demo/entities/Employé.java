package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "EMPLOYE")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employé implements Serializable {
     
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
	@SequenceGenerator(name = "employe_generator", sequenceName = "Employe_SEQ", initialValue = 1, allocationSize = 1)
	@Column(name = "idPrime", updatable = false, nullable = false , unique = true)
   private Long idEmployé ;
	
	@Column(name = "nomEmployé", length = 50, nullable = false)
   private String nomEmployé ;
	
	@Column(name = "prenomEmployé", length = 50, nullable = false)
   private String prenomEmployé ;
	
	@Column(name = "cin", nullable = false)
   private long cin ;
	
	public Long getIdEmployé() {
		return idEmployé;
	}

	public void setIdEmployé(Long idEmployé) {
		this.idEmployé = idEmployé;
	}

	public String getNomEmployé() {
		return nomEmployé;
	}

	public void setNomEmployé(String nomEmployé) {
		this.nomEmployé = nomEmployé;
	}

	public String getPrenomEmployé() {
		return prenomEmployé;
	}

	public void setPrenomEmployé(String prenomEmployé) {
		this.prenomEmployé = prenomEmployé;
	}

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public long getCnss() {
		return cnss;
	}

	public void setCnss(long cnss) {
		this.cnss = cnss;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getSituationFami() {
		return situationFami;
	}

	public void setSituationFami(String situationFami) {
		this.situationFami = situationFami;
	}

	public int getNbreEnfant() {
		return nbreEnfant;
	}

	public void setNbreEnfant(int nbreEnfant) {
		this.nbreEnfant = nbreEnfant;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "cnss", nullable = false)
   private long cnss ;
	
	@Column(name = "tel", nullable = false)
   private long tel ;
	
	@Column(name = "dateNaiss", nullable = false)
   private Date dateNaiss ;
	
	@Column(name = "situationFami", nullable = false)
   private String situationFami ;
	
	@Column(name = "nbreEnfant", nullable = false)
   private int nbreEnfant ;
	
	@Column(name = "Email", nullable = true)
	private String Email ;
	
	@Column(name = "adresse", nullable = false)
	   private String adresse ;
	
}
