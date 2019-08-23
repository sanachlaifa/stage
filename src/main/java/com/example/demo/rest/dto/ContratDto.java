package com.example.demo.rest.dto;

import java.util.Collection;
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
public class ContratDto {
	private Long idContrat ;
	private String typeContrat ;
	private Date dateDebut ;
	private Date dateFin ;
	private String typeSalaire ;
	private Float salaireBase ;
	private Collection<FichePaieDto> ficheDto ;
	private Collection<PrimeDto> primeDto;
	private Collection<AbattementDto> abattementDto;
	private Collection<ImpotDto> impotDto;
	private Collection<ParametreDto> parametreDto;
}





