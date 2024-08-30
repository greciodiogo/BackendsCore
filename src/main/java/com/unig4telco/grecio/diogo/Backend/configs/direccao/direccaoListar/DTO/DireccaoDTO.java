package com.unig4telco.grecio.diogo.Backend.configs.direccao.direccaoListar.DTO;

import com.unig4telco.grecio.diogo.Backend.configs.direccao._domain.Direccao;

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
