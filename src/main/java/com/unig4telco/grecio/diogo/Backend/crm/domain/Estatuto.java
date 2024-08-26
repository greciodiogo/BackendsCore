package com.unig4telco.grecio.diogo.Backend.crm.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="estatutos")
@Table(name = "estatutos")
public class Estatuto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean status;
    private Integer escalao_estatuto_id;
    private Integer user_id;
    
    @Column(name = "numero_mecanografico")
    private String numeroMecanografico;

    @Column(name = "created_at")
    private String createdAt;
    
    @Column(name = "updated_at")
    private String updatedAt;
}
