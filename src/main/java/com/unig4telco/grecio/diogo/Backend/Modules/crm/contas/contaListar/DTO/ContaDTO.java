package com.unig4telco.grecio.diogo.Backend.Modules.crm.contas.contaListar.DTO;

import java.util.Date;

import com.unig4telco.grecio.diogo.Backend.Modules.configs.direccao.direccaoListar.DTO.DireccaoDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas._domain.Conta;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.contas.tipoContaListar.DTO.TipoContaDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.geografica.DTO.PaisDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.geografica.DTO.ProvinciaDTO;
import com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.DTO.MoedaDTO;

public record ContaDTO(

    Integer id,
    String contaDescricao,
    String gestorConta,
    String tipoFacturacao,
    Integer moeda_id,
    MoedaDTO moeda,
    Integer direccao_id,
    DireccaoDTO direccao,
    Boolean estado,
    Boolean is_deleted,
    Integer cliente_id,
    String morada,
    Integer pais_id,
    PaisDTO pais,
    Integer provincia_id,
    ProvinciaDTO provincia,
    String telefone,
    String email,
    Date createdAt,
    Date updatedAt,
    String aprovacao_documentacao,
    Integer tipo_conta_id,
    TipoContaDTO tipoConta,
    Integer user_id

){    public ContaDTO(Conta conta) {
        this(
        conta.getId(),
        conta.getContaDescricao(),
        conta.getGestorConta(),
        conta.getTipoFacturacao(),
        conta.getMoeda() != null ? conta.getMoeda().getId() : null,
        conta.getMoeda() != null ? new MoedaDTO(conta.getMoeda()) : null,
        conta.getDireccao() != null ? conta.getDireccao().getId() : null,
        conta.getDireccao() != null ? new DireccaoDTO(conta.getDireccao()) : null,
        conta.getEstado(),
        conta.getIsDeleted(),
        conta.getCliente() != null ? conta.getCliente().getId() : null,
        conta.getMorada(),
        conta.getPais() != null ? conta.getPais().getId() : null,
        conta.getPais() != null ? new PaisDTO(conta.getPais()) : null,
        conta.getProvincia() != null ? conta.getProvincia().getId() : null,
        conta.getProvincia() != null ? new ProvinciaDTO(conta.getProvincia()) : null,
        conta.getTelefone(),
        conta.getEmail(),
        conta.getCreatedAt(),
        conta.getUpdatedAt(),
        conta.getAprovacaoDocumentacao(),
        conta.getTipoConta() != null ? conta.getTipoConta().getId() : null,
        conta.getTipoConta() != null ? new TipoContaDTO(conta.getTipoConta()) : null,
        conta.getUser_id()
        );    
    }
}
