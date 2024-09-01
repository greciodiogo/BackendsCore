package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="escalao_estatutos")
@Table(name = "escalao_estatutos")
public class EstatutoEscalao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean status;
    private Integer saldo;
    private String slug;
    private String categoria;
    private Integer user_id;

    @Column(name = "created_at")
    private String createdAt;
    
    @Column(name = "updated_at")
    private String updatedAt;
}

