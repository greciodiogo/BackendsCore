package com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia.tecnologiaListar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia._services.TecnologiaService;
import com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia.tecnologiaListar.DTO.TecnologiaDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.crm._controllers.DTO.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.crm._controllers.DTO.PaginationResponse;

@RestController
@RequestMapping("/tecnologias")
public class TecnologiasListarController {
    @Autowired
    private TecnologiaService tecnologiaService;

        @GetMapping
    public ResponseEntity<ApiResponseDTO<TecnologiaDTO>> getTecnologias() {
        var pageResponse = tecnologiaService.findAll();
       
        ApiResponseDTO<TecnologiaDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }
}

