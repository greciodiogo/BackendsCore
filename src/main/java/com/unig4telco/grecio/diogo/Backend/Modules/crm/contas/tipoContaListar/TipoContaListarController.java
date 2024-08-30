package com.unig4telco.grecio.diogo.Backend.Modules.crm.contas.tipoContaListar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas._services.TipoContaService;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas.tipoContaListar.DTO.TipoContaDTO;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/tipo_conta")
public class TipoContaListarController {

    @Autowired
    private TipoContaService tipocontaService;

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

}
