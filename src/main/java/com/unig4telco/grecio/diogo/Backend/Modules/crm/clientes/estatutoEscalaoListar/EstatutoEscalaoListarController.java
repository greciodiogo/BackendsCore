package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.estatutoEscalaoListar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unig4telco.grecio.diogo.Backend.Helpers.EnvelopeResponse;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain.EstatutoEscalao;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._repositories.EstatutoEscalaoRepository;

@RestController
@RequestMapping("/form")
public class EstatutoEscalaoListarController {
    @Autowired
    private EstatutoEscalaoRepository estatutoEscalaoRepository;

    @GetMapping("/getEscalaoCategoria")
    public <T> ResponseEntity<EnvelopeResponse<List<EstatutoEscalao>>> getTypesClient(String status) {
        // Obtenha a lista de EstatutoEscalao
        List<EstatutoEscalao> data = estatutoEscalaoRepository.findByStatus(true);
        // Converta a saída para EnvelopeResponse<List<EstatutoEscalao>>
        EnvelopeResponse<List<EstatutoEscalao>> response = new EnvelopeResponse<>(data, null, null);

        return ResponseEntity.ok(response);

    }
}