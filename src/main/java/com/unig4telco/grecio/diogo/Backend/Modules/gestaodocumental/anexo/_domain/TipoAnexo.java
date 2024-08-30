package com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="tipo_anexos")
@Table(name = "tipo_anexos")
public class TipoAnexo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private String area;
    private Integer tipo_anexo_id_pai;
    @Column(name = "tipo_bancario")
    private Boolean tipoBancario;
    @Column(name = "tipoDependencia")
    private String tipoDependencia;
    private Boolean is_deleted;
    private Integer user_id;
    
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;
}
