package com.unig4telco.grecio.diogo.Backend.Modules.geografica.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="paises")
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Boolean is_actived;
    private Boolean is_deleted;
    private Date created_at;
    private Date updated_at;
}
