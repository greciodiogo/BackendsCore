package com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._repositories.AnexoMotivoRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.repositories.dto.AnexoMotivoDTO;

@RestController
@RequestMapping("/anexomotivo")
public class AnexoMotivo {
    @Autowired
    private AnexoMotivoRepository anexoMotivoRepository;

        @GetMapping
    public ResponseEntity<List<AnexoMotivoDTO>> getAnexoMotivos() {
        var lista = anexoMotivoRepository.findAll().stream().map(AnexoMotivoDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}
