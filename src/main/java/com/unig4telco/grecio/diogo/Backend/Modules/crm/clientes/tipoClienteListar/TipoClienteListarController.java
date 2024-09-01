package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoClienteListar;


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
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.TipoCliente;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._repositories.TipoClienteRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoClienteListar.DTO.TipoClienteDTO;

@RestController
@RequestMapping("/tipo_clientes")
public class TipoClienteListarController {
    @Autowired
    private TipoClienteRepository tipoClienteRepository;

        @GetMapping
    public ResponseEntity<ApiResponseDTO<TipoClienteDTO>> index() {

        Pageable pageable = PageRequest.of(0, 5);
        Specification<TipoCliente> spec = Specification.where(null);
        Page<TipoCliente> query = tipoClienteRepository.findAll(spec, pageable);
        
        var pageResponse = query.map(TipoClienteDTO::new);

        ApiResponseDTO<TipoClienteDTO> data = new ApiResponseDTO<>(
                pageResponse.getContent(), // Dados paginados
                PaginationResponse.fromPage(pageResponse), // MetaData
                null, // Mensagem (ou passe uma string)
                200 // Código de status
        );
        return ResponseEntity.ok(data);
    }


}