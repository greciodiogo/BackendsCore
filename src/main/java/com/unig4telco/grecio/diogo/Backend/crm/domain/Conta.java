package com.unig4telco.grecio.diogo.Backend.crm.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

import com.unig4telco.grecio.diogo.Backend.utilitarios.domain.Moeda;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="contas")
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contaDescricao;
    private String gestorConta;
    private String tipoFacturacao;

    @ManyToOne
    @JoinColumn(name="moeda_id", referencedColumnName = "id")
    private Moeda moeda;
    
    @ManyToOne
    @JoinColumn(name="direccao_id", referencedColumnName = "id")
    private Direccao direccao;
    
    private Boolean estado;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @ManyToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private Clientes cliente;
    private String morada;
    private String telefone;
    private String email;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "aprovacao_documentacao")
    private String aprovacaoDocumentacao;
    
    @ManyToOne
    @JoinColumn(name="tipo_conta_id", referencedColumnName = "id")
    private TipoConta tipoConta;
    
    private Integer user_id;
}
