package com.example.demo.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable{
    private static final long serialVersionUID = -680290809469712849L;
    @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Column(name= "MATRICULE", nullable=false)
   private Long matricule;
   @Column(name= "NOM")
   private String nom;
   @Column(name= "PRENOM")
   private String prenom;
   @Column(name= "CIVILITE")
   private String civilite;
   @Column(name= "CIN", unique=true)
   private String cin;
   @Column(name= "DATE_DELIVRANCE_CIN")
   private String dateDelivranceCin;
   @Column(name= "LIEU_DELIVRANCE_CIN")
   private String lieuDelivranceCin;
   @Column(name= "DATE_NAISSANCE")
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date dateNaissance;
   @Column(name= "SITUDATION_FAMILIALE")
   private String situationFamiliale;
   @Column(name= "NBENFANTS")
   private Integer nbEnfants;
   @Column(name= "ADRESSE")
   private String adresse;
    @Column(name = "LONGITUDE")
    private Double longitude;
    @Column(name = "LATITUDE")
    private Double latitude;
   @Column(name= "TEL")
   private Integer tel;
   @Column(name= "FAX")
   private Integer fax;
   @Column(name= "LOGIN")
   private String login;
   @Column(name= "MOT_DE_PASSE")
   private String motDePasse;
   @Column(name= "NUM_PERMIS", unique=true)
   private String numPermis;
   @Column(name= "NUM_CNSS")
   private String numCnss;
   @Column(name= "RIB")
   private String rib;
   @Column(name= "NOM_BANQUE")
   private String nomBanque;
   @Column(name= "TYPE_PERMIS")
   private String typePermis;
   @Column(name= "MAIL")
   private String mail;
  
   @OneToMany(mappedBy="employee", cascade= {CascadeType.MERGE, CascadeType.PERSIST}, fetch= FetchType.LAZY)
   private Set<Enfant> enfants;
   @OneToMany(mappedBy="employee", cascade= {CascadeType.MERGE, CascadeType.PERSIST}, fetch= FetchType.LAZY)
   private Set<Contrat> contrats;
  
   @OneToMany(mappedBy="employee", cascade= {CascadeType.MERGE, CascadeType.PERSIST}, fetch= FetchType.LAZY)
   private Set<Presence> presence;

}