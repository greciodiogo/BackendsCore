package com.unig4telco.grecio.diogo.Backend.utilitarios.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="bancos")
@Table(name = "bancos")
public class Bancos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String abreviatura;
    private Boolean activo;
    private Boolean is_deleted;
    private Integer user_id;
    private Integer moeda_id;
    private String numero_conta;
    private String iban;
    private Date created_at;
    private Date updated_at;

}
