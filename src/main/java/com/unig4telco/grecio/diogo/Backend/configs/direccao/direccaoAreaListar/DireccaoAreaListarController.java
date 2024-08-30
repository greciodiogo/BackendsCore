package com.unig4telco.grecio.diogo.Backend.configs.direccao.direccaoAreaListar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.configs.direccao._services.DireccaoAreaService;
import com.unig4telco.grecio.diogo.Backend.configs.direccao.direccaoAreaListar.DTO.DireccaoAreaDTO;
import com.unig4telco.grecio.diogo.Backend.crm._controllers.DTO.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.crm._controllers.DTO.PaginationResponse;

@RestController
@RequestMapping("/direccao_areas")
public class DireccaoAreaListarController {

    private final DireccaoAreaService direccaoareaService;

    public DireccaoAreaListarController(DireccaoAreaService direccaoareaService) {
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
