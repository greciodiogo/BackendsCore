package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.crm.domain.Proposta;
import com.unig4telco.grecio.diogo.Backend.crm.services.PropostaService;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    private final PropostaService propostaService;

    public PropostaController(PropostaService propostaService) {
        this.propostaService = propostaService;
    }

    @GetMapping
    public ResponseEntity<List<Proposta>> findAll() {
        List<Proposta> lista = propostaService.findAll();
        return ResponseEntity.ok(lista);
    }
}
