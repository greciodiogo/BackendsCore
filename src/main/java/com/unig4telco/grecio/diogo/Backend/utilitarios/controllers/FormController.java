package com.unig4telco.grecio.diogo.Backend.utilitarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.TipoClienteDTO;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.crm.domain.TipoCliente;
import com.unig4telco.grecio.diogo.Backend.crm.repositories.TipoClienteRepository;
import com.unig4telco.grecio.diogo.Backend.utilitarios.DTO.BancosListDTO;
import com.unig4telco.grecio.diogo.Backend.utilitarios.DTO.CambioDTO;
import com.unig4telco.grecio.diogo.Backend.utilitarios.DTO.DocumentoDTO;
import com.unig4telco.grecio.diogo.Backend.utilitarios.DTO.MoedaDTO;
import com.unig4telco.grecio.diogo.Backend.utilitarios.DTO.OrganismoDTO;
import com.unig4telco.grecio.diogo.Backend.utilitarios.DTO.SerieDTO;
import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.Bancos;
import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.Cambio;
import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.Documento;
import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.Moeda;
import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.Organismo;
import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.Serie;
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
    @Autowired
    private TipoClienteRepository tipoClienteRepository;

        @GetMapping("/bancos")
    public ResponseEntity<ApiResponseDTO<BancosListDTO>> getBancos() {
        Pageable pageable = PageRequest.of(1,5);
        Specification<Bancos> spec = Specification.where(null);
        Page<Bancos> bancos = bancosRepository.findAll(spec,pageable);
        var pageResponse = bancos.map(BancosListDTO::new);
        
        ApiResponseDTO<BancosListDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

        @GetMapping("/moedas")
    public ResponseEntity<ApiResponseDTO<MoedaDTO>> getMoeda() {
        
        Pageable pageable = PageRequest.of(1,5);
        Specification<Moeda> spec = Specification.where(null);
        Page<Moeda> moedas = moedaRepository.findAll(spec,pageable);
        var pageResponse = moedas.map(MoedaDTO::new);
    
        ApiResponseDTO<MoedaDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

        @GetMapping("/organismos")
    public ResponseEntity<ApiResponseDTO<OrganismoDTO>> getOrganismo() {
        
        Pageable pageable = PageRequest.of(1,5);
        Specification<Organismo> spec = Specification.where(null);
        Page<Organismo> organismos = organismoRepository.findAll(spec,pageable);
        var pageResponse = organismos.map(OrganismoDTO::new);
        
        ApiResponseDTO<OrganismoDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

        @GetMapping("/cambios")
    public ResponseEntity<ApiResponseDTO<CambioDTO>> getCambios() {
        
        Pageable pageable = PageRequest.of(1,5);
        Specification<Cambio> spec = Specification.where(null);
        Page<Cambio> cambio = cambioRepository.findAll(spec,pageable);
        var pageResponse = cambio.map(CambioDTO::new);
        
        ApiResponseDTO<CambioDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

        @GetMapping("/documentos")
    public ResponseEntity<ApiResponseDTO<DocumentoDTO>> getDocumentos() {
        
        Pageable pageable = PageRequest.of(1,5);
        Specification<Documento> spec = Specification.where(null);
        Page<Documento> documentos = documentoRepository.findAll(spec,pageable);
        var pageResponse = documentos.map(DocumentoDTO::new);
        
        ApiResponseDTO<DocumentoDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

        @GetMapping("/series")
    public ResponseEntity<ApiResponseDTO<SerieDTO>> getSeries() {
        
        Pageable pageable = PageRequest.of(1,5);
        Specification<Serie> spec = Specification.where(null);
        Page<Serie> serie = serieRepository.findAll(spec,pageable);
        var pageResponse = serie.map(SerieDTO::new);
        
        ApiResponseDTO<SerieDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }
 
    @GetMapping("/getTypesClient")
    public ResponseEntity<ApiResponseDTO<TipoClienteDTO>> getTypesClient() {

        Pageable pageable = PageRequest.of(1,5);
        Specification<TipoCliente> spec = Specification.where(null);
        Page<TipoCliente> tipoCliente = tipoClienteRepository.findAll(spec,pageable);

        var pageResponse = tipoCliente.map(TipoClienteDTO::new);
        
        ApiResponseDTO<TipoClienteDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
        
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

