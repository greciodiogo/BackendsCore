package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.nacionalidade._repositories;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="tipo_nacionalidades")
@Table(name = "tipo_nacionalidades")
public class TipoNacionalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String slug;
}