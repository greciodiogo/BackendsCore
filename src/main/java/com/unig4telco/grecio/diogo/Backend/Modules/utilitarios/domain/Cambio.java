package com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="cambios")
@Table(name = "cambios")
public class Cambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double valor_cambio;
    
    private Boolean is_actived;
    private Boolean is_deleted;
    
    @ManyToOne
    @JoinColumn(name = "moeda_id", referencedColumnName = "id")
    private Moeda moeda;
    
    private Integer user_id;

    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;

}
