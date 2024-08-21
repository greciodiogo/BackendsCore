package com.unig4telco.grecio.diogo.Backend.crm.domain;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="tipo_clientes")
@Table(name = "tipo_clientes")
public class TipoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String slug;
}