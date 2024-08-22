package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.EstadoCivilDTO;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.EstadoCivilRepository;


@RestController
@RequestMapping("/estado_civils")
public class EstadoCivilController {
    @Autowired
    private EstadoCivilRepository estadoCivilRepository;

        @GetMapping
    public ResponseEntity<List<EstadoCivilDTO>> getEstadoCivil() {
        var lista = estadoCivilRepository.findAll().stream().map(EstadoCivilDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}