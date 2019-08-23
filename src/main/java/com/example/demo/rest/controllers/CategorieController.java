package com.example.demo.rest.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

import com.example.demo.model.entities.Categorie;
import com.example.demo.rest.dto.CategorieDto;
import com.example.demo.services.CategorieService;


@CrossOrigin("*")
@RestController()
public class CategorieController {
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/Categories")
    public Object CategoriesList() {
        List<Categorie> categories = categorieService.getAllCategorie();
        Type listType = new TypeToken<List<CategorieDto>>() {
        }.getType();
        List<CategorieDto> categorieDtos = modelMapper.map(categories, listType);
        return ResponseEntity.status(HttpStatus.OK).body(categorieDtos);
    }
    @GetMapping("/Categories/{id}")
    public Object retrieveCategorie(@PathVariable long id) {
        Categorie categorie = categorieService.getCategorie(id);
        CategorieDto categorieDto = modelMapper.map(categorie, CategorieDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(categorieDto);
    }
    @PostMapping("/Categories")
    public Object addCategorie(@Valid @RequestBody CategorieDto categorieDto) {
        Categorie categorie = modelMapper.map(categorieDto, Categorie.class);
        categorie = categorieService.saveCategorie(categorie);
        categorieDto = modelMapper.map(categorie, CategorieDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(categorieDto);
    }
    
    @PutMapping("/Categories/{id}")
    public Object updateCategorie(@Valid @RequestBody CategorieDto categorieDto, @PathVariable long id) {
        Categorie categorie = modelMapper.map(categorieDto, Categorie.class);
        categorie = categorieService.updateCategorie(id, categorie);
        categorieDto = modelMapper.map(categorie, CategorieDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(categorieDto);
    }
    
    @DeleteMapping("/Categories/{id}")
    public Object DeleteCategorie(@PathVariable("id") Long id) {
        categorieService.deleteCategorie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
