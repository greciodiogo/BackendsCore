package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.TecnologiaDTO;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.crm.services.TecnologiaService;

@RestController
@RequestMapping("/tecnologias")
public class TecnologiasController {
    @Autowired
    private TecnologiaService tecnologiaService;

        @GetMapping
    public ResponseEntity<ApiResponseDTO<TecnologiaDTO>> getTecnologias() {
        var pageResponse = tecnologiaService.findAll();
       
        ApiResponseDTO<TecnologiaDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

        @GetMapping("/getTecnologiasByType")
    public ResponseEntity<ApiResponseDTO<TecnologiaDTO>> getTecnologiasByType(
        @RequestParam(defaultValue = "") String tipoFacturacao
    ) {
        
        var pageResponse = tecnologiaService.findByTipoFacturacao(tipoFacturacao);
       
        ApiResponseDTO<TecnologiaDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }
}

