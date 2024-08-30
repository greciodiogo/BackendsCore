package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.proposta._domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="propostas")
@Table(name = "propostas")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipo;
    private String descricao;
    private String estado;
    private Integer cliente_id;

    @Column(name = "created_at")    
    private Date createdAt;

    // @Column(name = "updated_at")    
    // private Date updatedAt;
}
