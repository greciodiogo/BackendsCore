package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos.generosListar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.EnvelopeResponse;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos._domain.Generos;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos._repositories.GeneroRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos.generosListar.DTO.GeneroDTO;


@RestController
@RequestMapping
public class GenerosListarController {
    @Autowired
    private GeneroRepository generoRepository;


            @GetMapping("/generos")
    public ResponseEntity<ApiResponseDTO<GeneroDTO>> generos() {
        Pageable pageable = PageRequest.of(0,5);
        Specification<Generos> spec = Specification.where(null);
        Page<Generos> generos = generoRepository.findAll(spec,pageable);
        var pageResponse = generos.map(GeneroDTO::new);
        
        ApiResponseDTO<GeneroDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }

    @GetMapping("/form/getGeneros")
     public ResponseEntity<EnvelopeResponse<List<GeneroDTO>>> getGeneros() {
        List<GeneroDTO> data = generoRepository.findAll().stream()
                .map(GeneroDTO::new)
                .toList();

        // Converta a saída para EnvelopeResponse<List<GeneroDTO>>
        EnvelopeResponse<List<GeneroDTO>> response = new EnvelopeResponse<>(data, null, null);
        return ResponseEntity.ok(response);
    }
}