package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.GeneroDTO;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.GeneroRepository;


@RestController
@RequestMapping("/generos")
public class GenerosController {
    @Autowired
    private GeneroRepository generoRepository;

        @GetMapping
    public ResponseEntity<List<GeneroDTO>> getGeneros() {
        var lista = generoRepository.findAll().stream().map(GeneroDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}