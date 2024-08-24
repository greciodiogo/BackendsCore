package com.unig4telco.grecio.diogo.Backend.crm.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="tecnologias")
@Table(name = "tecnologias")
public class Tecnologia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome; 
    private String opcao;
    private Boolean is_sip; 
    // @Column(name = "tipoFacturacao")
    // private String facturacao;
    private String rota_insert_dispositivo;
    private String rota_list_dispositivo; 
    private Integer user_id; ;
    
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;
}
