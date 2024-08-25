package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.TecnologiaDTO;
import com.unig4telco.grecio.diogo.Backend.crm.services.TecnologiaService;

@RestController
@RequestMapping("/tecnologias")
public class TecnologiasController {
    @Autowired
    private TecnologiaService tecnologiaService;

        @GetMapping
    public ResponseEntity<List<TecnologiaDTO>> getTecnologias() {
        var lista = tecnologiaService.findAll().stream().map(TecnologiaDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

        @GetMapping("/getTecnologiasByType")
    public ResponseEntity<List<TecnologiaDTO>> getTecnologiasByType(
        @RequestParam(defaultValue = "") String tipoFacturacao
    ) {
        var lista = tecnologiaService.findByTipoFacturacao(tipoFacturacao).stream().map(TecnologiaDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}

