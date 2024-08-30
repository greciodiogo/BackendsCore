package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteListar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._services.ClienteService;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteListar.DTO.ListClientesDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteListar.DTO.RequestClientListDTO;

@RestController
@RequestMapping("/clientes")
public class ClienteListarController {
   @Autowired
   private ClienteService clienteService;
    
    @GetMapping
    public ResponseEntity<ApiResponseDTO<ListClientesDTO>> index( RequestClientListDTO filters) {
    
        var pageResponse = clienteService.findAll(filters);

        ApiResponseDTO<ListClientesDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

}
