package com.unig4telco.grecio.diogo.Backend.Modules.configs.direccao.direccaoListar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Helpers.EnvelopeResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.configs.direccao._repositories.DireccaoRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.configs.direccao.direccaoListar.DTO.DireccaoDTO;
@RestController
@RequestMapping("/direccao")
public class DireccaoController {
    @Autowired
    private DireccaoRepository direccaoRepository;

        @GetMapping
      public ResponseEntity<EnvelopeResponse<List<DireccaoDTO>>> getDireccao() {
        List<DireccaoDTO> data = direccaoRepository.findAll().stream()
                .map(DireccaoDTO::new)
                .toList();

        // Converta a saída para EnvelopeResponse<List<DireccaoDTO>>
        EnvelopeResponse<List<DireccaoDTO>> response = new EnvelopeResponse<>(data, null, null);
        return ResponseEntity.ok(response);
    }
}

