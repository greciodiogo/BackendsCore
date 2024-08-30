package com.unig4telco.grecio.diogo.Backend.Modules.geografica.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="municipios")
@Table(name = "municipios")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
        
    @ManyToOne
    @JoinColumn(name="provincia_id", referencedColumnName = "id")
    private Provincia provincia;

    private Boolean is_actived;
    private Boolean is_deleted;
    private Date created_at;
    private Date updated_at;
}
