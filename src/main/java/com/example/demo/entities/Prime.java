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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name = "PRIME")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Prime implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
	@SequenceGenerator(name = "prime_generator", sequenceName = "Prime_SEQ", initialValue = 1, allocationSize = 1)
	@Column(name = "idPrime", updatable = false, nullable = false)
	
 private Long idPrime ;
	@Column(name = "valeurPrime", nullable = false)
 private Float valeurPrime ;
 public String getOption() {
	return option;
}
public void setOption(String option) {
	this.option = option;
}
public String[] getMoisAff() {
	return moisAff;
}
public void setMoisAff(String[] moisAff) {
	this.moisAff = moisAff;
}
public Date getDateCreationPrime() {
	return dateCreationPrime;
}
public void setDateCreationPrime(Date dateCreationPrime) {
	this.dateCreationPrime = dateCreationPrime;
}
@Column(name = "option", length = 50, nullable = false)
private String option ;
@Column(name = "moisAff", nullable = false)
 private String  [] moisAff ;
 public Long getIdPrime() {
	return idPrime;
}
public void setIdPrime(Long idPrime) {
	this.idPrime = idPrime;
}
public Float getValeurPrime() {
	return valeurPrime;
}
public void setValeurPrime(Float valeurPrime) {
	this.valeurPrime = valeurPrime;
}
public String getNomPrime() {
	return nomPrime;
}
public void setNomPrime(String nomPrime) {
	this.nomPrime = nomPrime;
}
@Column(name = "nomPrime", length = 50, nullable = false)
private String nomPrime ;
@Column(name = "dateCreationPrime", nullable = false)
@Temporal(TemporalType.DATE)
private Date dateCreationPrime ;
}
