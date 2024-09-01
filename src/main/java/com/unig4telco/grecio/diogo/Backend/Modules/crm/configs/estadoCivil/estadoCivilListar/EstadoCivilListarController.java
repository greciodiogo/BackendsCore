package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil.estadoCivilListar;

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
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil._repositories.EstadoCivilRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil.estadoCivilListar.DTO.EstadoCivilDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil._domain.EstadoCivil;

@RestController
@RequestMapping
public class EstadoCivilListarController {
    @Autowired
    private EstadoCivilRepository estadoCivilRepository;

    @GetMapping("/estado_civils")
    public ResponseEntity<ApiResponseDTO<EstadoCivilDTO>> getEstadoCivil() {
        Pageable pageable = PageRequest.of(0, 5);
        Specification<EstadoCivil> spec = Specification.where(null);
        Page<EstadoCivil> estadoCivil = estadoCivilRepository.findAll(spec, pageable);
        var pageResponse = estadoCivil.map(EstadoCivilDTO::new);

        ApiResponseDTO<EstadoCivilDTO> data = new ApiResponseDTO<>(
                pageResponse.getContent(), // Dados paginados
                PaginationResponse.fromPage(pageResponse), // MetaData
                null, // Mensagem (ou passe uma string)
                200 // Código de status
        );
        return ResponseEntity.ok(data);
    }

    @GetMapping("/form/getEstadoCivils")
    public ResponseEntity<EnvelopeResponse<List<EstadoCivilDTO>>> formGetEstadoCivil() {
        List<EstadoCivilDTO> data = estadoCivilRepository.findAll().stream()
                .map(EstadoCivilDTO::new)
                .toList();

        // Converta a saída para EnvelopeResponse<List<EstadoCivilDTO>>
        EnvelopeResponse<List<EstadoCivilDTO>> response = new EnvelopeResponse<>(data, null, null);
        return ResponseEntity.ok(response);
    }
}