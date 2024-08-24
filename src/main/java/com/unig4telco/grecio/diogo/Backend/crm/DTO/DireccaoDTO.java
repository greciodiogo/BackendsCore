package com.unig4telco.grecio.diogo.Backend.crm.DTO;

import com.unig4telco.grecio.diogo.Backend.crm.domain.Direccao;

public record DireccaoDTO(
    Integer id,
    String designacao,
    String slug,
    String descricao
) {
    public DireccaoDTO(Direccao direccao){
        this(
            direccao.getId(),
            direccao.getDesignacao(),
            direccao.getSlug(),
            direccao.getDescricao()
        );
    }
    
}
