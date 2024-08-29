package com.unig4telco.grecio.diogo.Backend.crm.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.DireccaoAreaDTO;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.crm.controllers.DTO.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.crm.services.DireccaoAreaService;

@RestController
@RequestMapping("/direccao_areas")
public class DireccaoAreaController {

    private final DireccaoAreaService direccaoareaService;

    public DireccaoAreaController(DireccaoAreaService direccaoareaService) {
        this.direccaoareaService = direccaoareaService;
    }
    
    @GetMapping
    public ResponseEntity<ApiResponseDTO<DireccaoAreaDTO>> index() {
    
        var pageResponse = direccaoareaService.findAll();

        ApiResponseDTO<DireccaoAreaDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }
}
