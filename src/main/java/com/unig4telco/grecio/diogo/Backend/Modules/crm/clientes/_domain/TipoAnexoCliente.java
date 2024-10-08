package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

import com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._domain.TipoAnexo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="tipo_anexo_clientes")
@Table(name = "tipo_anexo_clientes")
public class TipoAnexoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean required;
    @Column(name="is_aprovacao")
    private Boolean isAprovacao;
    private String descricao;
    @Column(name="is_actived")
    private Boolean isActived;
    @Column(name="is_deleted")
    private Boolean idDeleted;
    @ManyToOne
    @JoinColumn(name="tipo_anexo_id", referencedColumnName = "id")
    private TipoAnexo tipoAnexo;
    @ManyToOne
    @JoinColumn(name="tipo_cliente_id", referencedColumnName = "id")
    private TipoCliente tipoCliente;
    private Integer user_id;
    @Column(name = "created_at")    
    private Date createdAt;
    @Column(name = "updated_at")    
    private Date updatedAt;

}
