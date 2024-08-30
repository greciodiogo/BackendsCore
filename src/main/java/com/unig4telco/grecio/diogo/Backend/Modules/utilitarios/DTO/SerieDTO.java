package com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.domain.Serie;

public record SerieDTO(
    Integer id,
    String nome,
    Integer proximo_numero,
    Boolean estado,
    Integer documento_id,
    DocumentoDTO documento
) {
    public SerieDTO(Serie serie){
        this(
            serie.getId(),
            serie.getNome(),
            serie.getProximo_numero(),
            serie.getEstado(),
            serie.getDocumento() != null ? serie.getDocumento().getId() : null,
            serie.getDocumento() != null ? new DocumentoDTO(serie.getDocumento()) : null
        );
    }
}
