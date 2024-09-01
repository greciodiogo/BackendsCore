package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoAnexoClienteListar;

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
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.TipoAnexoCliente;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.tipoAnexoClienteListar.DTO.TipoAnexoClienteDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._repositories.TipoAnexoClienteRepository;

@RestController
@RequestMapping
public class TipoAnexoClienteListarController {

    @Autowired
    private TipoAnexoClienteRepository tipoAnexoClienteRepository;

    @GetMapping("/tipo_clientes/tipoAnexoClientes")
    public ResponseEntity<ApiResponseDTO<TipoAnexoClienteDTO>> index() {

        Pageable pageable = PageRequest.of(0, 5);
        Specification<TipoAnexoCliente> spec = Specification.where(null);
        Page<TipoAnexoCliente> query = tipoAnexoClienteRepository.findAll(spec, pageable);
        
        var pageResponse = query.map(TipoAnexoClienteDTO::new);

        ApiResponseDTO<TipoAnexoClienteDTO> data = new ApiResponseDTO<>(
                pageResponse.getContent(), // Dados paginados
                PaginationResponse.fromPage(pageResponse), // MetaData
                null, // Mensagem (ou passe uma string)
                200 // Código de status
        );
        return ResponseEntity.ok(data);
    }

    // @GetMapping("/form/getTypesIdentities")
    // public ResponseEntity<EnvelopeResponse<List<TipoAnexoClienteDTO>>> getTypesIdentities() {

    //     List<TipoAnexoClienteDTO> data = tipoAnexoClienteRepository.findAll().stream()
    //             .map(TipoAnexoClienteDTO::new)
    //             .toList();

    //     // Converta a saída para EnvelopeResponse<List<MoedaDTO>>
    //     EnvelopeResponse<List<TipoAnexoClienteDTO>> response = new EnvelopeResponse<>(data, null, null);
    //     return ResponseEntity.ok(response);
    // }
}