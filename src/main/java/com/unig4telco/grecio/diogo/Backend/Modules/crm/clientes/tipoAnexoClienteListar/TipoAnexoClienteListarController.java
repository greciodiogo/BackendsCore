package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoAnexoClienteListar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoAnexoClienteListar.DTO.TipoAnexoClienteDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._services.TipoAnexoClienteService;


@RestController
@RequestMapping("/tipo_clientes")
public class TipoAnexoClienteListarController {

    @Autowired
    private TipoAnexoClienteService tipoAnexoClienteService;

    @GetMapping("/tipoAnexoClientes")
    public ResponseEntity<ApiResponseDTO<TipoAnexoClienteDTO>> index() {
    
        var pageResponse = tipoAnexoClienteService.findAll();

        ApiResponseDTO<TipoAnexoClienteDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }
}