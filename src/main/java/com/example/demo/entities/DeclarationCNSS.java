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
public class DeclarationCNSS implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idDecCNSS ;

    @Temporal(TemporalType.DATE)
	private Date dateCreaDec ;

    public Long getIdDecCNSS() {
		return idDecCNSS;
	}
	public void setIdDecCNSS(Long idDecCNSS) {
		this.idDecCNSS = idDecCNSS;
	}
	public Date getDateCreaDec() {
		return dateCreaDec;
	}
	public void setDateCreaDec(Date dateCreaDec) {
		this.dateCreaDec = dateCreaDec;
	}
	public Date getDatePay() {
		return datePay;
	}
	public void setDatePay(Date datePay) {
		this.datePay = datePay;
	}
	public Float getMontantCNSS() {
		return montantCNSS;
	}
	public void setMontantCNSS(Float montantCNSS) {
		this.montantCNSS = montantCNSS;
	}
	@Temporal(TemporalType.DATE)
	private Date datePay ;
	private Float montantCNSS ;
}
