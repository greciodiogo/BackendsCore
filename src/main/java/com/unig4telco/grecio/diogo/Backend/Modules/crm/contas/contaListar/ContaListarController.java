package com.unig4telco.grecio.diogo.Backend.Modules.crm.contas.contaListar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas._services.ContaService;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas.contaListar.DTO.ContaDTO;

@RestController
@RequestMapping("/contas")
public class ContaListarController {

    private final ContaService contaService;

    public ContaListarController(ContaService contaService) {
        this.contaService = contaService;
    }

      @GetMapping("/cliente")
    public ResponseEntity<ApiResponseDTO<ContaDTO>> index() {
    
        var pageResponse = contaService.findAll();

        ApiResponseDTO<ContaDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }
}
