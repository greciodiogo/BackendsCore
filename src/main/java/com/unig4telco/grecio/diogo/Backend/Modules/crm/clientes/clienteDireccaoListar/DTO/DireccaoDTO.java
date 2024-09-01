package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes.clienteDireccaoListar.DTO;

import com.unig4telco.grecio.diogo.Backend.Modules.configs.direccao._domain.Direccao;

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
