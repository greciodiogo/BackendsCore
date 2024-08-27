package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.TipoAnexoContaDTO;
import com.unig4telco.grecio.diogo.Backend.crm.DTO.TipoContaDTO;
import com.unig4telco.grecio.diogo.Backend.crm.services.TipoAnexoContaService;
import com.unig4telco.grecio.diogo.Backend.crm.services.TipoContaService;

@RestController
@RequestMapping("/tipo_conta")
public class TipoContaController {

    private final TipoContaService tipocontaService;
    @Autowired
    private TipoAnexoContaService tipoanexocontaService;

    public TipoContaController(TipoContaService tipocontaService) {
        this.tipocontaService = tipocontaService;
    }

    @GetMapping
    public ResponseEntity<List<TipoContaDTO>> findAll() {
        List<TipoContaDTO> lista = tipocontaService.findAll().stream().map(TipoContaDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

        @GetMapping("/tipoanexoconta")
    public ResponseEntity<List<TipoAnexoContaDTO>> findTipoAnexoConta() {
        List<TipoAnexoContaDTO> lista = tipoanexocontaService.findAll().stream().map(TipoAnexoContaDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}
