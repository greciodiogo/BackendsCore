package com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia.tecnologiaByTipoListar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.EnvelopeResponse;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia._services.TecnologiaService;
import com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia.tecnologiaListar.DTO.TecnologiaDTO;

@RestController
@RequestMapping
public class TecnologiasbyTipoListarController {
    @Autowired
    private TecnologiaService tecnologiaService;

        @GetMapping("/tecnologias/getTecnologiasByType")
    public ResponseEntity<ApiResponseDTO<TecnologiaDTO>> getTecnologiasByType(
        @RequestParam(defaultValue = "") String tipoFacturacao
    ) {
        
        var pageResponse = tecnologiaService.findAll();
       
        ApiResponseDTO<TecnologiaDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

        @GetMapping("/form/getTecnologiasByType")
        public ResponseEntity<EnvelopeResponse<List<TecnologiaDTO>>> formGetTecnologiasByType(
            @RequestParam(defaultValue = "") String tipoFacturacao
        ) {
        List<TecnologiaDTO> data = tecnologiaService.findByTipoFacturacao(tipoFacturacao);

        // Converta a saída para EnvelopeResponse<List<TecnologiaDTO>>
        EnvelopeResponse<List<TecnologiaDTO>> response = new EnvelopeResponse<>(data, null, null);
        return ResponseEntity.ok(response);
    }
}

