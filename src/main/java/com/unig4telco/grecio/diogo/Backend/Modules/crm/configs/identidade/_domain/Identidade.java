package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade._domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="identidades")
@Table(name = "identidades")
public class Identidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero_identidade;
    private Boolean is_deleted;

    @OneToOne
    @JoinColumn(name = "tipo_identidade_id", referencedColumnName = "id")
    private TipoIdentidade tipoIdentidade;

    private Date created_at;
    private Date updated_at;
}