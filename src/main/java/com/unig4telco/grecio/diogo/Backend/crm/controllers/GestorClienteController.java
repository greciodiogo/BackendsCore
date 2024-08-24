package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.GestorClienteDTO;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.GestorClienteRepository;

@RestController
@RequestMapping("/gestors/cliente")
public class GestorClienteController {
    @Autowired
    private GestorClienteRepository gestorClienteRepository;

        @GetMapping
    public ResponseEntity<List<GestorClienteDTO>> getoresCliente() {
        var lista = gestorClienteRepository.findAll().stream().map(GestorClienteDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}

