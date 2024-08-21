package com.unig4telco.grecio.diogo.Backend.utilitarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.utilitarios.DTO.BancosListDTO;
import com.unig4telco.grecio.diogo.Backend.utilitarios.repositories.BancosRepository;

@RestController
@RequestMapping("/api/bancos")
public class BancosController {
    @Autowired
    private BancosRepository bancosRepository;

        @GetMapping
    public ResponseEntity<List<BancosListDTO>> getBancos() {
        var lista = bancosRepository.findAll().stream().map(BancosListDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

}

