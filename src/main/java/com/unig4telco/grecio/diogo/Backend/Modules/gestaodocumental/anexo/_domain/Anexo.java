package com.unig4telco.grecio.diogo.Backend.Modules.gestaodocumental.anexo._domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="anexos")
@Table(name = "anexos")
public class Anexo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String anexotable;
    private Integer anexotable_id;
    private String filename;
    private String path;
    private String formato;
    private Double tamanho;
    private String unidade;
    private Boolean estado;
    private Boolean is_deleted;

       @ManyToOne
    @JoinColumn(name="tipo_anexo_id", referencedColumnName = "id")
    private TipoAnexo tipoAnexo;

    private Integer user_id;
    // @Column(name = "data_validade")
    // private LocalDateConverter dataValidade; 
    
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;
}
