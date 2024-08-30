package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.entidadeCativadorasListar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._services.EntidadeCativadoraService;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.entidadeCativadorasListar.DTO.EntidadeCativadoraDTO;

@RestController
@RequestMapping("/entidade_cativadoras")
public class EntidadeCativadoraListarController {
    @Autowired
    private EntidadeCativadoraService entidadeCativadoraService;

        @GetMapping
    public ResponseEntity<ApiResponseDTO<EntidadeCativadoraDTO>> index() {
    
        var pageResponse = entidadeCativadoraService.findAll();

        ApiResponseDTO<EntidadeCativadoraDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

}