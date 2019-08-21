package com.example.demo.rest.dto;



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
public class PresenceDto {
	private Long idPres ;
	private Long idSal ;
	private Long nbreJoursPres ;
	private String mois ;
	private Long année ;
	private Long nbreHeuresPres ;
	private Long nbreHeuresSupp ;

}
