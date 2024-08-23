package com.unig4telco.grecio.diogo.Backend.utilitarios.DTO;

import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.Documento;

public record DocumentoDTO(
    Integer id,
    String nome,
    String sigla,
    Boolean credito,
    Boolean debito,
    Boolean estado
) {
    public DocumentoDTO(Documento documento) {
        this(
            documento.getId(),
            documento.getNome(),
            documento.getSigla(),
            documento.getCredito(),
            documento.getDebito(),
            documento.getEstado()
        );
    }
    
}
