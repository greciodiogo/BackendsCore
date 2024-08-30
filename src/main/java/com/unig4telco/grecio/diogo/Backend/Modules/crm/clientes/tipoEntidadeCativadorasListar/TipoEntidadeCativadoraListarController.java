package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoEntidadeCativadorasListar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._services.TipoEntidadeCativadoraService;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoEntidadeCativadorasListar.DTO.TipoEntidadeCativadoraDTO;

@RestController
@RequestMapping("/tipo_entidade_cativadoras")
public class TipoEntidadeCativadoraListarController {
    @Autowired
    private TipoEntidadeCativadoraService tipoEntidadeCativadoraService;

        @GetMapping
    public ResponseEntity<ApiResponseDTO<TipoEntidadeCativadoraDTO>> index() {
    
        var pageResponse = tipoEntidadeCativadoraService.findAll();

        ApiResponseDTO<TipoEntidadeCativadoraDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

}