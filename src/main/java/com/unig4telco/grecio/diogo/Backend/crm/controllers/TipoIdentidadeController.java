package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.TipoIdentidadeDTO;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.TipoIdentidadeRepository;


@RestController
@RequestMapping("/api/tipo_identidades")
public class TipoIdentidadeController {
    @Autowired
    private TipoIdentidadeRepository tipoIdentidadeRepository;

        @GetMapping
    public ResponseEntity<List<TipoIdentidadeDTO>> getTipoIdentidades() {
        var lista = tipoIdentidadeRepository.findAll().stream().map(TipoIdentidadeDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}