package com.unig4telco.grecio.diogo.Backend.gestaodocumental.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.gestaodocumental.dto.AnexoMotivoDTO;
import com.unig4telco.grecio.diogo.Backend.gestaodocumental.repositories.AnexoMotivoRepository;

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
