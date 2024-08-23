package com.unig4telco.grecio.diogo.Backend.utilitarios.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="series")
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer proximo_numero;
    private Boolean estado;
    private Boolean is_deleted;

    @ManyToOne
    @JoinColumn(name="documento_id", referencedColumnName = "id")
    private Documento documento;

    private Integer user_id;
    
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;

}
