package com.example.demo.rest.dto;

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
public class PrimeDto {

		private Long idPrime ;
		 private Float valeurPrime ;
		 private String nomPrime ;
		 private Date dateCreationPrime ;
		 private String option ;
		 private String  [] moisAff ;
 
}
