package com.unig4telco.grecio.diogo.Backend.utilitarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.utilitarios.DTO.BancosListDTO;
import com.unig4telco.grecio.diogo.Backend.utilitarios.DTO.CambioDTO;
import com.unig4telco.grecio.diogo.Backend.utilitarios.DTO.DocumentoDTO;
import com.unig4telco.grecio.diogo.Backend.utilitarios.DTO.MoedaDTO;
import com.unig4telco.grecio.diogo.Backend.utilitarios.DTO.OrganismoDTO;
import com.unig4telco.grecio.diogo.Backend.utilitarios.DTO.SerieDTO;
import com.unig4telco.grecio.diogo.Backend.utilitarios.repositories.BancosRepository;
import com.unig4telco.grecio.diogo.Backend.utilitarios.repositories.CambioRepository;
import com.unig4telco.grecio.diogo.Backend.utilitarios.repositories.DocumentoRepository;
import com.unig4telco.grecio.diogo.Backend.utilitarios.repositories.MoedaRepository;
import com.unig4telco.grecio.diogo.Backend.utilitarios.repositories.OrganismoRepository;
import com.unig4telco.grecio.diogo.Backend.utilitarios.repositories.SerieRepository;

@RestController
@RequestMapping("/form")
public class FormController {
    @Autowired
    private BancosRepository bancosRepository;
    @Autowired
    private MoedaRepository moedaRepository;
    @Autowired
    private OrganismoRepository organismoRepository;
    @Autowired
    private CambioRepository cambioRepository;
    @Autowired
    private DocumentoRepository documentoRepository;
    @Autowired
    private SerieRepository serieRepository;

        @GetMapping("/bancos")
    public ResponseEntity<List<BancosListDTO>> getBancos() {
        var lista = bancosRepository.findAll().stream().map(BancosListDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

        @GetMapping("/moedas")
    public ResponseEntity<List<MoedaDTO>> getMoeda() {
        var lista = moedaRepository.findAll().stream().map(MoedaDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

        @GetMapping("/organismos")
    public ResponseEntity<List<OrganismoDTO>> getOrganismo() {
        var lista = organismoRepository.findAll().stream().map(OrganismoDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

        @GetMapping("/cambios")
    public ResponseEntity<List<CambioDTO>> getCambios() {
        var lista = cambioRepository.findAll().stream().map(CambioDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

        @GetMapping("/documentos")
    public ResponseEntity<List<DocumentoDTO>> getDocumentos() {
        var lista = documentoRepository.findAll().stream().map(DocumentoDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

        @GetMapping("/series")
    public ResponseEntity<List<SerieDTO>> getSeries() {
        var lista = serieRepository.findAll().stream().map(SerieDTO::new).toList();
        return ResponseEntity.ok(lista);
    }
 
}

