package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade.tipoIdentidadeListar;

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
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade._domain.TipoIdentidade;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade._repositories.TipoIdentidadeRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade.tipoIdentidadeListar.DTO.TipoIdentidadeDTO;


@RestController
@RequestMapping("/tipo_identidades")
public class TipoIdentidadeController {
    @Autowired
    private TipoIdentidadeRepository tipoIdentidadeRepository;

            @GetMapping
    public ResponseEntity<ApiResponseDTO<TipoIdentidadeDTO>> getTipoIdentidades() {
        Pageable pageable = PageRequest.of(1,5);
        Specification<TipoIdentidade> spec = Specification.where(null);
        Page<TipoIdentidade> tipoIdentidade = tipoIdentidadeRepository.findAll(spec,pageable);
        var pageResponse = tipoIdentidade.map(TipoIdentidadeDTO::new);
        
        ApiResponseDTO<TipoIdentidadeDTO> data = new ApiResponseDTO<>(
            pageResponse.getContent(),                            // Dados paginados
            PaginationResponse.fromPage(pageResponse),            // MetaData
            null,                                         // Mensagem (ou passe uma string)
            200                                        // Código de status
            );
        return ResponseEntity.ok(data);
    }
}