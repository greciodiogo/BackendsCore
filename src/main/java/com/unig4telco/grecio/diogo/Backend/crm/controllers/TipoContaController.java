package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.TipoAnexoContaDTO;
import com.unig4telco.grecio.diogo.Backend.crm.DTO.TipoContaDTO;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.PaginationResponse;
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
    public ResponseEntity<ApiResponseDTO<TipoContaDTO>> index() {
    
        var pageResponse = tipocontaService.findAll();

        ApiResponseDTO<TipoContaDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

    @GetMapping("/tipoanexoconta")
    public ResponseEntity<ApiResponseDTO<TipoAnexoContaDTO>> findTipoAnexoConta() {
    
        var pageResponse = tipoanexocontaService.findAll();

        ApiResponseDTO<TipoAnexoContaDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }
}
