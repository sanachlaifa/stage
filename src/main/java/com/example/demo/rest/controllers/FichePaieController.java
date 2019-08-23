package com.example.demo.rest.controllers;

import java.lang.reflect.Type;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.example.demo.services.FichePaieService;
import com.example.demo.model.entities.FichePaie;
import com.example.demo.rest.dto.FichePaieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController()
public class FichePaieController {
    @Autowired
    private FichePaieService ficheService;
    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping("/FichePaies")
    public Object FichePaiesList() {
        List<FichePaie> fiches = ficheService.getAllFichePaie();
        Type listType = new TypeToken<List<FichePaieDto>>() {
        }.getType();
        List<FichePaieDto> ficheDtos = modelMapper.map(fiches, listType);
        return ResponseEntity.status(HttpStatus.OK).body(ficheDtos);
    }
    @GetMapping("/FichePaies/{id}")
    public Object retrieveFichePaie(@PathVariable long id) {
        FichePaie fiche = ficheService.getFichePaie(id);
        FichePaieDto ficheDto = modelMapper.map(fiche, FichePaieDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(ficheDto);
    }
    @PostMapping("/FichePaies")
    public Object addFichePaie(@Valid @RequestBody FichePaieDto ficheDto, @Valid @RequestBody Long idEmploye, @Valid @RequestBody Long idContrat) {
        FichePaie fiche = modelMapper.map(ficheDto, FichePaie.class);
        fiche  = ficheService.saveFichePaie(fiche , idEmploye, idContrat);
        ficheDto = modelMapper.map(fiche , FichePaieDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(ficheDto);
    }
    
    @PutMapping("/FichePaies/{id}")
    public Object updateFichePaie(@Valid @RequestBody FichePaieDto ficheDto, @PathVariable Long id, Long idContrat, Long idEmploye) {
        FichePaie fiche = modelMapper.map(ficheDto, FichePaie.class);
        fiche = ficheService.updateFichePaie(id, fiche, idEmploye, idContrat);
        ficheDto = modelMapper.map(fiche, FichePaieDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(ficheDto);
    }
    
    @DeleteMapping("/FichePaies/{id}")
    public Object Delete(@PathVariable("id") Long id) {
    	ficheService.deleteFichePaie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }  
}
