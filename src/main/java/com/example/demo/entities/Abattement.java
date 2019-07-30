package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Abattement implements Serializable  {
	/**
	 * 
	 */
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAbat ;
	private String nomAbat ;
	private String optionAbat ;
	private Float valAbat ;
	public Long getIdAbat() {
		return idAbat;
	}
	public void setIdAbat(Long idAbat) {
		this.idAbat = idAbat;
	}
	public String getNomAbat() {
		return nomAbat;
	}
	public void setNomAbat(String nomAbat) {
		this.nomAbat = nomAbat;
	}
	public String getOptionAbat() {
		return optionAbat;
	}
	public void setOptionAbat(String optionAbat) {
		this.optionAbat = optionAbat;
	}
	public Float getValAbat() {
		return valAbat;
	}
	public void setValAbat(Float valAbat) {
		this.valAbat = valAbat;
	}
}
