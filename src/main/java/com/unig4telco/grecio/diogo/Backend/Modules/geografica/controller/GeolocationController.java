package com.unig4telco.grecio.diogo.Backend.Modules.geografica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Helpers.EnvelopeResponse;
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

        @GetMapping("/getProvincesByPais")
    public <T> ResponseEntity<EnvelopeResponse<List<ProvinciaDTO>>> getProvincesByPais(@RequestParam(required = false) Integer paisId) {
        List<ProvinciaDTO> provincies = provinciaRepository.findByPaisId(paisId).stream()
        .map(ProvinciaDTO::new).toList();

        EnvelopeResponse<List<ProvinciaDTO>> response = new EnvelopeResponse<>(provincies, null, null);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getMunicipiosByProvinciaId")
    public ResponseEntity<EnvelopeResponse<List<MuncipioDTO>>> getMunicipiosByProvinciaId(@RequestParam(required = false) Integer provinciaId) {
        List<MuncipioDTO> municipios = municipioRepository.findByProvinciaId(provinciaId).stream()
        .map(MuncipioDTO::new).toList();

        EnvelopeResponse<List<MuncipioDTO>> response = new EnvelopeResponse<>(municipios, null, null);

        return ResponseEntity.ok(response);
    }

       @GetMapping("/getPaises")
    public <T> ResponseEntity<EnvelopeResponse<List<PaisDTO>>> getPaises() {
        // Obtenha a lista de PaisDTO
        List<PaisDTO> data = paisRepository.findAll().stream()
                .map(PaisDTO::new)
                .toList();

        // Converta a saída para EnvelopeResponse<List<PaisDTO>>
        EnvelopeResponse<List<PaisDTO>> response = new EnvelopeResponse<>(data, null, null);

        return ResponseEntity.ok(response);
    }
}
