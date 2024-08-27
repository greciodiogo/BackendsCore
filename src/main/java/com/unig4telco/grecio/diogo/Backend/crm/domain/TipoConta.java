package com.unig4telco.grecio.diogo.Backend.crm.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="tipo_contas")
@Table(name = "tipo_contas")
public class TipoConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String slug;
    private String tipoFacturacao;
    private Integer user_id;
    @Column(name = "is_venda")    
    private Boolean isVenda;
    @Column(name = "is_actived")    
    private Boolean isActived;
    @Column(name = "is_deleted")    
    private Boolean isDeleted;
    @Column(name = "created_at")    
    private Date createdAt;
    @Column(name = "updated_at")    
    private Date updatedAt;
}
