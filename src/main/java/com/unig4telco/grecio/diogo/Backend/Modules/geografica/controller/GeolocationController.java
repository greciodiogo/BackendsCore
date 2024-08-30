package com.unig4telco.grecio.diogo.Backend.Modules.geografica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Modules.geografica.DTO.MuncipioDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.geografica.DTO.PaisDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.geografica.DTO.ProvinciaDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.geografica.repositories.MunicipioRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.geografica.repositories.PaisRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.geografica.repositories.ProvinciaRepository;

@RestController
@RequestMapping("/form")
public class GeolocationController {
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private ProvinciaRepository provinciaRepository;
    @Autowired
    private MunicipioRepository municipioRepository;

        @GetMapping("/getPaises")
    public ResponseEntity<List<PaisDTO>> getPaises() {
        var lista = paisRepository.findAll().stream().map(PaisDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

        @GetMapping("/getProvincesByPais")
    public ResponseEntity<List<ProvinciaDTO>> getProvincesByPais(@RequestParam(required = false) Integer paisId) {
        var provincies = provinciaRepository.findByPaisId(paisId).stream()
        .map(ProvinciaDTO::new).toList();
        return ResponseEntity.ok(provincies);
    }

    @GetMapping("/getMunicipiosByProvinciaId")
    public ResponseEntity<List<MuncipioDTO>> getMunicipiosByProvinciaId(@RequestParam(required = false) Integer provinciaId) {
        var provincies = municipioRepository.findByProvinciaId(provinciaId).stream()
        .map(MuncipioDTO::new).toList();
        return ResponseEntity.ok(provincies);
    }
}
