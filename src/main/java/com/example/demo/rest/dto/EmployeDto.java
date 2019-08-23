package com.example.demo.rest.dto;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class EmployeDto {
	 private Long matricule;
	   private String nom;
	   private String prenom;
	   private String civilite;
	   private String cin;
	   private String dateDelivranceCin;
	   private String lieuDelivranceCin;
	   private Date dateNaissance;
	   private String situationFamiliale;
	   private String adresse;
	   private String codePostal;
	   private String ville;
	   private Integer tel;
	   private Integer fax;
	   private String descriptionPoste;
	   private String login;
	   private String motDePasse;
	   private String roleE;
	   private String numPermis;
	   private String numCnss;
	   private String rib;
	   private String nomBanque;
	   private String typePermis;
	   private String mail;
	   private Integer actif = 1;
	   private Integer valider;
	   private Collection<EnfantDto> enfantDtos;
	   private Collection<ContratDto> contratDtos;
	   private Collection<FichePaieDto> ficheDtos;
	   private Collection<PresenceDto> presenceDtos;
}



  

