package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.unig4telco.grecio.diogo.Backend.crm.domain.Estatuto;
import com.unig4telco.grecio.diogo.Backend.crm.services.EstatutoService;

@RestController
@RequestMapping("/estatutos")
public class EstatutoController {

    private final EstatutoService estatutoService;

    public EstatutoController(EstatutoService estatutoService) {
        this.estatutoService = estatutoService;
    }

    @GetMapping
    public ResponseEntity<List<Estatuto>> findAll() {
        List<Estatuto> lista = estatutoService.findAll();
        return ResponseEntity.ok(lista);
    }
}
