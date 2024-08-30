package com.unig4telco.grecio.diogo.Backend.configs.direccao._domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="direccaos")
@Table(name = "direccaos")
public class Direccao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String designacao;
    private String slug;
    private String descricao;
    private Boolean is_actived;
    private Boolean is_comercial;
    private Boolean is_deleted;
    private Integer user_id;
    
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;
}
