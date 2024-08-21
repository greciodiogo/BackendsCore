package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.TipoNacionalidadeDTO;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.TipoNacionalidadeRepository;


@RestController
@RequestMapping("/tipo_nacionalidade")
public class TipoNacionalidadeController {
    @Autowired
    private TipoNacionalidadeRepository tipoNacionalidadeRepository;

        @GetMapping
    public ResponseEntity<List<TipoNacionalidadeDTO>> getTipoClientes() {
        var lista = tipoNacionalidadeRepository.findAll().stream().map(TipoNacionalidadeDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}