package com.example.demo.rest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class EmployeDto {
	   private Long idEmployé ;
	   private String nomEmployé ;
	   private String prenomEmployé ;
	   private long cin ;
	   private long cnss ;
	   private long tel ;
	   private String Email ;
	   private String adresse ;
	   private Date dateNaiss ;
	   private String situationFami ;
	   private int nbreEnfant ;

}
