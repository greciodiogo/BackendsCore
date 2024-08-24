package com.unig4telco.grecio.diogo.Backend.gestaodocumental.dto;

import com.unig4telco.grecio.diogo.Backend.gestaodocumental.domain.TipoAnexo;

public record TipoAnexoDTO(
    Integer id,
    String nome,
    String descricao,
    String area,
    Integer tipo_anexo_id_pai,
    Boolean tipoBancario
    // String tipoDependencia
) {
    public TipoAnexoDTO(TipoAnexo tipoAnexo){
        this(
            tipoAnexo.getId(),
            tipoAnexo.getNome(),
            tipoAnexo.getDescricao(),
            tipoAnexo.getArea(),
            tipoAnexo.getTipo_anexo_id_pai(),
            tipoAnexo.getTipoBancario()
            // tipoAnexo.getTipoDependencia()
        );
    }
    
}
