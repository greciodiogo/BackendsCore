package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.nacionalidade.tipoNacionalidadeListar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Helpers.EnvelopeResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.nacionalidade._repositories.TipoNacionalidadeRepository;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.nacionalidade.tipoNacionalidadeListar.DTO.TipoNacionalidadeDTO;


@RestController
@RequestMapping
public class TipoNacionalidadeListarController {
    @Autowired
    private TipoNacionalidadeRepository tipoNacionalidadeRepository;

        @GetMapping("/tipo_nacionalidade")
    public ResponseEntity<List<TipoNacionalidadeDTO>> getTipoClientes() {
        var lista = tipoNacionalidadeRepository.findAll().stream().map(TipoNacionalidadeDTO::new).toList();
        return ResponseEntity.ok(lista);
    }

            @GetMapping("/form/getTypesNacionalidade")
    public ResponseEntity<EnvelopeResponse<List<TipoNacionalidadeDTO>>> getTypesNacionalidade() {
        List<TipoNacionalidadeDTO> data = tipoNacionalidadeRepository.findAll().stream()
                .map(TipoNacionalidadeDTO::new)
                .toList();

        // Converta a saída para EnvelopeResponse<List<MoedaDTO>>
        EnvelopeResponse<List<TipoNacionalidadeDTO>> response = new EnvelopeResponse<>(data, null, null);
        return ResponseEntity.ok(response);
    }
}