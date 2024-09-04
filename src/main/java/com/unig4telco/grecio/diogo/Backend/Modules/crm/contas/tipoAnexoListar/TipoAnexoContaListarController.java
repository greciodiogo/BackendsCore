package com.unig4telco.grecio.diogo.Backend.Modules.crm.contas.tipoAnexoListar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas.tipoAnexoListar.DTO.TipoAnexoContaDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._services.TipoAnexoContaService;

@RestController
@RequestMapping("/tipo_conta")
public class TipoAnexoContaListarController {

    @Autowired
    private TipoAnexoContaService tipoanexocontaService;

    @GetMapping("/tipoanexoconta")
    public ResponseEntity<ApiResponseDTO<TipoAnexoContaDTO>> findTipoAnexoConta() {
    
        var data = findAllTipoAnexo();
        return ResponseEntity.ok(data);
    }


    public ApiResponseDTO<TipoAnexoContaDTO> findAllTipoAnexo() {
    
        var pageResponse = tipoanexocontaService.findAll();

        ApiResponseDTO<TipoAnexoContaDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return data;
    }

}
