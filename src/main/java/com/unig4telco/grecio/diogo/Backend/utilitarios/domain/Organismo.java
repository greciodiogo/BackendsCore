package com.unig4telco.grecio.diogo.Backend.utilitarios.domain;

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
    
    @Column(name = "createdAt")
    private Date created_at;
    
    @Column(name = "updatedAt")
    private Date updated_at;

}
