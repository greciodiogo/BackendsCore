package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.DireccaoArea;

public record DireccaoAreaDTO(

    Integer id,
    String nome,
    String slug,
    Integer direccao_id,
    DireccaoDTO direccao
    
){    public DireccaoAreaDTO(DireccaoArea direccaoarea) {
        this(
        direccaoarea.getId(),
        direccaoarea.getNome(),
        direccaoarea.getSlug(),
        direccaoarea.getDireccao() != null ? direccaoarea.getDireccao().getId() : null,
        direccaoarea.getDireccao() != null ? new DireccaoDTO(direccaoarea.getDireccao()) : null
);    }
}
