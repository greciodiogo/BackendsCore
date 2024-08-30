package com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.repositories.dto;

import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._domain.Anexo;

public record AnexoDTO(
    Integer id,
    String anexotable,
    Integer anexotable_id,
    String filename,
    String path,
    String formato,
    Double tamanho,
    Integer tipoAnexo_id,
    TipoAnexoDTO tipoAnexo,
    String unidade,
    Boolean estado
    // LocalDateTime data_validade
    
) {
    public AnexoDTO(Anexo anexo){
        this(
            anexo.getId(),
            anexo.getAnexotable(),
            anexo.getAnexotable_id(),
            anexo.getFilename(),
            anexo.getPath(),
            anexo.getFormato(),
            anexo.getTamanho(),
            anexo.getTipoAnexo() != null ? anexo.getTipoAnexo().getId() : null,
            anexo.getTipoAnexo() != null ? new TipoAnexoDTO(anexo.getTipoAnexo()) : null,
            anexo.getUnidade(),
            anexo.getEstado()
            // anexo.getData_validade()
        );
    }
}
