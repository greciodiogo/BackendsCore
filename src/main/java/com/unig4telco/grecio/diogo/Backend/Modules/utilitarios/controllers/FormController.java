package com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Helpers.EnvelopeResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._repositories.TipoClienteRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoClienteListar.DTO.TipoClienteDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.DTO.CambioDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.DTO.DocumentoDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.DTO.MoedaDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.DTO.OrganismoDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.DTO.SerieDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.repositories.CambioRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.repositories.DocumentoRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.repositories.MoedaRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.repositories.OrganismoRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.repositories.SerieRepository;

@RestController
@RequestMapping("/form")
public class FormController {
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
    @Autowired
    private TipoClienteRepository tipoClienteRepository;

    @GetMapping("/getMoedas")
    public ResponseEntity<EnvelopeResponse<List<MoedaDTO>>> getMoeda() {
        List<MoedaDTO> data = moedaRepository.findAll().stream()
                .map(MoedaDTO::new)
                .toList();

        // Converta a saída para EnvelopeResponse<List<MoedaDTO>>
        EnvelopeResponse<List<MoedaDTO>> response = new EnvelopeResponse<>(data, null, null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getOrganismos")
    public ResponseEntity<EnvelopeResponse<List<OrganismoDTO>>> getOrganismo() {

        List<OrganismoDTO> data = organismoRepository.findAll().stream()
                .map(OrganismoDTO::new)
                .toList();

        // Converta a saída para EnvelopeResponse<List<OrganismoDTO>>
        EnvelopeResponse<List<OrganismoDTO>> response = new EnvelopeResponse<>(data, null, null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/cambios")
    public ResponseEntity<EnvelopeResponse<List<CambioDTO>>> getCambios() {

        List<CambioDTO> data = cambioRepository.findAll().stream()
                .map(CambioDTO::new)
                .toList();

        // Converta a saída para EnvelopeResponse<List<CambioDTO>>
        EnvelopeResponse<List<CambioDTO>> response = new EnvelopeResponse<>(data, null, null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getDocumentos")
    public ResponseEntity<EnvelopeResponse<List<DocumentoDTO>>> getDocumentos() {

        List<DocumentoDTO> data = documentoRepository.findAll().stream()
                .map(DocumentoDTO::new)
                .toList();

        // Converta a saída para EnvelopeResponse<List<DocumentoDTO>>
        EnvelopeResponse<List<DocumentoDTO>> response = new EnvelopeResponse<>(data, null, null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/series")
    public ResponseEntity<EnvelopeResponse<List<SerieDTO>>> getSeries() {
        List<SerieDTO> data = serieRepository.findAll().stream()
                .map(SerieDTO::new)
                .toList();

        // Converta a saída para EnvelopeResponse<List<SerieDTO>>
        EnvelopeResponse<List<SerieDTO>> response = new EnvelopeResponse<>(data, null, null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getTypesClient")
    public <T> ResponseEntity<EnvelopeResponse<List<TipoClienteDTO>>> getTypesClient() {
        // Obtenha a lista de TipoClienteDTO
        List<TipoClienteDTO> data = tipoClienteRepository.findAll().stream()
                .map(TipoClienteDTO::new)
                .toList();

        // Converta a saída para EnvelopeResponse<List<TipoClienteDTO>>
        EnvelopeResponse<List<TipoClienteDTO>> response = new EnvelopeResponse<>(data, null, null);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/getTypesClientBySlug")
    public ResponseEntity<List<TipoClienteDTO>> getTypesClientBySlug(@RequestParam(required = false) String slug) {
        if (slug != null) {
            var tipoCliente = tipoClienteRepository.findBySlug(slug).stream()
                    .map(TipoClienteDTO::new).toList();
            return ResponseEntity.ok(tipoCliente);
        } else {
            var lista = tipoClienteRepository.findAll().stream()
                    .map(TipoClienteDTO::new)
                    .toList();
            return ResponseEntity.ok(lista);
        }
    }

}
