package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteContaDebitoListar;


import java.util.List;

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
import com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia._domain.Tecnologia;
import com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia.tecnologiaListar.DTO.TecnologiaDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.ClienteContaDebito;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._repositories.ClienteDebitoContaRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteContaDebitoListar.DTO.ClienteContaDebitoDTO;

@RestController
@RequestMapping("/form/getDebitoContaByClienteId")
public class ClienteContaDebitoListarController {
    @Autowired
    private ClienteDebitoContaRepository clienteDebitoContaRepository;

        @GetMapping
    public ResponseEntity<ApiResponseDTO<ClienteContaDebitoDTO>> index(String cliente_id) {

        Pageable pageable = PageRequest.of(0, 5);
        Specification<ClienteContaDebito> spec = Specification.where(null);
        if (cliente_id != null && cliente_id.isEmpty()) {
            spec = spec.and(
                    (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("cliente_id"), cliente_id));
        }
        Page<ClienteContaDebito> query = clienteDebitoContaRepository.findAll(spec, pageable);
        
        var pageResponse = query.map(ClienteContaDebitoDTO::new);

        ApiResponseDTO<ClienteContaDebitoDTO> data = new ApiResponseDTO<>(
                pageResponse.getContent(), // Dados paginados
                PaginationResponse.fromPage(pageResponse), // MetaData
                null, // Mensagem (ou passe uma string)
                200 // Código de status
        );
        return ResponseEntity.ok(data);
    }

}