package com.example.demo.rest.dto;

import java.util.Date;


import com.example.demo.model.enumeration.Situation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AbattementDto {
    private Long idAbat ;
    private Situation situation ;
    private float valeur ;
	private Date dateAbat ;

}
