package com.unig4telco.grecio.diogo.Backend.Modules.utilitarios.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="organismos")
@Table(name = "organismos")
public class Organismo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private String sigla;
    private Boolean is_actived;
    private Boolean is_deleted;
    private Integer user_id;
    
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;

}
