package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.Tecnologia;

public record TecnologiaDTO(
    Integer id,
    String nome, 
    String opcao,
    Boolean is_sip
    // String facturacao
) {
    public TecnologiaDTO(Tecnologia tecnologia){
        this(
            tecnologia.getId(),
            tecnologia.getNome(),
            tecnologia.getOpcao(),
            tecnologia.getIs_sip()
            // tecnologia.getFacturacao()
        );
    }

    
}
