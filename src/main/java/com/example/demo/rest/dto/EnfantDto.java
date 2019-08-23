package com.example.demo.rest.dto;



import com.example.demo.model.enumeration.Etat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class EnfantDto {
	private Long id;
	   private Etat etatEnfant;
}
