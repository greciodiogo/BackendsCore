package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="entidade_cativadoras")
@Table(name = "entidade_cativadoras")
public class EntidadeCativadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private Clientes cliente;
    private Integer valor;
    @Column(name="is_actived")
    private Boolean isActived;
    @Column(name="is_deleted")
    private Boolean idDeleted;
    @ManyToOne
    @JoinColumn(name="tipo_entidade_cativadora_id", referencedColumnName = "id")
    private TipoEntidadeCativadora tipoEntidadeCativadora;
    private Integer user_id;
    @Column(name = "created_at")    
    private Date createdAt;
    @Column(name = "updated_at")    
    private Date updatedAt;

}
