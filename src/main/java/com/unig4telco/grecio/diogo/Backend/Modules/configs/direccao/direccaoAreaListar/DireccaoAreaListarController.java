package com.unig4telco.grecio.diogo.Backend.Modules.configs.direccao.direccaoAreaListar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.configs.direccao._services.DireccaoAreaService;
import com.unig4telco.grecio.diogo.Backend.Modules.configs.direccao.direccaoAreaListar.DTO.DireccaoAreaDTO;

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
