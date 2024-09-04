package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil._domain;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "estado_civils")
@Table(name = "estado_civils")
public class EstadoCivil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String slug;

    private Boolean is_actived;
    private Boolean is_deleted;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

}