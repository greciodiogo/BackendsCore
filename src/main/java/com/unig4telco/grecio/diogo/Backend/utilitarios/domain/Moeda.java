package com.unig4telco.grecio.diogo.Backend.utilitarios.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="moedas")
@Table(name = "moedas")
public class Moeda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    
    @Column(name = "codigo_iso")
    private String codigoIso;
    
    private String descricao;
    private String unidade_fracionaria;
    private Boolean activo;
    private Boolean is_deleted;
    private Integer user_id;
    
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;

}
