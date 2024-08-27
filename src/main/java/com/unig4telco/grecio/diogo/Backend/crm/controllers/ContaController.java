package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.crm.DTO.ContaDTO;
import com.unig4telco.grecio.diogo.Backend.crm.services.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public ResponseEntity<List<ContaDTO>> findAll() {
        List<ContaDTO> lista = contaService.findAll().stream().map(ContaDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}
