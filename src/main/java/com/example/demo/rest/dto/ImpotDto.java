package com.example.demo.rest.dto;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ImpotDto {
	private Long idImpotRev ;
	private Double borneSup ;
	private Double borneInf ;
	private Double taux ;

}
