package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteGestorListar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._repositories.GestorClienteRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteGestorListar.DTO.GestorClienteDTO;

@RestController
@RequestMapping("/gestors/cliente")
public class ClienteGestorListarController {
    @Autowired
    private GestorClienteRepository gestorClienteRepository;

        @GetMapping
    public ResponseEntity<List<GestorClienteDTO>> getoresCliente() {
        var lista = gestorClienteRepository.findAll().stream().map(GestorClienteDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}

