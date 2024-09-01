package com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Helpers.ApiResponseDTO;
import com.unig4telco.grecio.diogo.Backend.Helpers.PaginationResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.DTO.BancosListDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.domain.Bancos;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.repositories.BancosRepository;

@RestController
@RequestMapping("/bancos")
public class BancosController {
    @Autowired
    private BancosRepository bancosRepository;

    @GetMapping
    public ResponseEntity<ApiResponseDTO<BancosListDTO>> getBancos() {
        Pageable pageable = PageRequest.of(1,5);
        Specification<Bancos> spec = Specification.where(null);
        Page<Bancos> bancos = bancosRepository.findAll(spec,pageable);
        var pageResponse = bancos.map(BancosListDTO::new);
        
        ApiResponseDTO<BancosListDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }
}
