package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.EstatutoDTO;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.crm.services.EstatutoService;

@RestController
@RequestMapping("/estatutos")
public class EstatutoController {

    private final EstatutoService estatutoService;

    public EstatutoController(EstatutoService estatutoService) {
        this.estatutoService = estatutoService;
    }


      @GetMapping
    public ResponseEntity<ApiResponseDTO<EstatutoDTO>> index() {
    
        var pageResponse = estatutoService.findAll();

        ApiResponseDTO<EstatutoDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

}
