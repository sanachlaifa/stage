package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parametres implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long idPar ;
 private String nomPar ;
 private Float valPar ;
 public Long getIdPar() {
	return idPar;
}
public String getNomPar() {
	return nomPar;
}
public void setNomPar(String nomPar) {
	this.nomPar = nomPar;
}
public Float getValPar() {
	return valPar;
}
public void setValPar(Float valPar) {
	this.valPar = valPar;
}
public void setIdPar(Long idPar) {
	this.idPar = idPar;
}

}

 
