package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade._domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="tipo_identidades")
@Table(name = "tipo_identidades")
public class TipoIdentidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String slug;
    private String regex;

    private Boolean estado;
    private Boolean is_deleted;
    
    private Date created_at;
    private Date updated_at;
}