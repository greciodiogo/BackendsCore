package com.unig4telco.grecio.diogo.Backend.geografica.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="distritos")
@Table(name = "distritos")
public class Distrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
        
    @ManyToOne
    @JoinColumn(name="municipio_id", referencedColumnName = "id")
    private Municipio municipio;

    private Boolean is_actived;
    private Boolean is_deleted;
    private Date created_at;
    private Date updated_at;
}
