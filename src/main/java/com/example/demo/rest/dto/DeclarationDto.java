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
public class DeclarationDto {
	   private Long idDecCNSS ;
	   private Date dateCreaDec ;
	   private Date datePay ;
		private Float montantCNSS ;
}
