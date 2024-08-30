package com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.repositories.dto.AnexoDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._repositories.AnexoRepository;


@RestController
@RequestMapping("/anexos")
public class AnexoController {
    @Autowired
    private AnexoRepository anexoRepository;

        @GetMapping
    public ResponseEntity<List<AnexoDTO>> getAnexos() {
        var lista = anexoRepository.findAll().stream().map(AnexoDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
}
