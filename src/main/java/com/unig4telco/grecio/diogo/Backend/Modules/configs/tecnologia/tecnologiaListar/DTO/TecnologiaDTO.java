package com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia.tecnologiaListar.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.configs.tecnologia._domain.Tecnologia;

public record TecnologiaDTO(
    Integer id,
    String nome, 
    String opcao,
    Boolean is_sip,
    String tipoFacturacao
) {
    public TecnologiaDTO(Tecnologia tecnologia){
        this(
            tecnologia.getId(),
            tecnologia.getNome(),
            tecnologia.getOpcao(),
            tecnologia.getIs_sip(),
            tecnologia.getTipoFacturacao()
        );
    }

    
}
