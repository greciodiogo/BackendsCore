package com.unig4telco.grecio.diogo.Backend.geografica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.geografica.DTO.PaisDTO;
import com.unig4telco.grecio.diogo.Backend.geografica.repositories.PaisRepository;

@RestController
@RequestMapping("/form")
public class GeolocationController {
    @Autowired
    private PaisRepository paisRepository;
    @Autowired

        @GetMapping("/getPaises")
    public ResponseEntity<List<PaisDTO>> getPaises() {
        var lista = paisRepository.findAll().stream().map(PaisDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}

