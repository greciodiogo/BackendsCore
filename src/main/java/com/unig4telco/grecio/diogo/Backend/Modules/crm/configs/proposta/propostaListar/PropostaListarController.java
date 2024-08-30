package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.proposta.propostaListar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.PropostaDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.proposta._services.PropostaService;

@RestController
@RequestMapping("/propostas")
public class PropostaListarController {

    private final PropostaService propostaService;

    public PropostaListarController(PropostaService propostaService) {
        this.propostaService = propostaService;
    }

          @GetMapping
    public ResponseEntity<ApiResponseDTO<PropostaDTO>> index() {
    
        var pageResponse = propostaService.findAll();

        ApiResponseDTO<PropostaDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }
}
