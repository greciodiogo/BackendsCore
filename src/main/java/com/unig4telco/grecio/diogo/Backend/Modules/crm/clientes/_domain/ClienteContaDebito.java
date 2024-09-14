package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="cliente_debito_contas")
@Table(name = "cliente_debito_contas")
public class ClienteContaDebito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String num_conta;
    private String iban;
    private String descricao;
    private Integer cliente_id;
    private Integer banco_id;

    @Column(name="is_actived")
    private Boolean isActived;
    @Column(name="is_deleted")
    private Boolean idDeleted;
    @Column(name = "created_at")    
    private Date createdAt;
    @Column(name = "updated_at")    
    private Date updatedAt;
    
    private Integer user_id;
}
