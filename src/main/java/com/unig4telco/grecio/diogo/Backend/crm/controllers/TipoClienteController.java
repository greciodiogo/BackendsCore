package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.TipoClienteDTO;
import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoAnexoCliente;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.TipoClienteRepository;
import com.unig4telco.grecio.diogo.Backend.crm.services.TipoAnexoClienteService;


@RestController
@RequestMapping("/tipo_clientes")
public class TipoClienteController {
    @Autowired
    private TipoClienteRepository tipoClienteRepository;

    @Autowired
    private TipoAnexoClienteService tipoAnexoClienteService;

        @GetMapping
    public ResponseEntity<List<TipoClienteDTO>> getTipoClientes() {
        var lista = tipoClienteRepository.findAll().stream().map(TipoClienteDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

       @GetMapping("/tipoAnexoClientes")
    public ResponseEntity<List<TipoAnexoCliente>> findAll() {
        List<TipoAnexoCliente> lista = tipoAnexoClienteService.findAll();
        return ResponseEntity.ok(lista);
    }
}