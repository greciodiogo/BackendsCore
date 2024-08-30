package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteEstatutoListar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._services.EstatutoService;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteEstatutoListar.DTO.EstatutoDTO;

@RestController
@RequestMapping("/estatutos")
public class ClienteEstatutoListarController {
    @Autowired
    private EstatutoService estatutoService;

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
