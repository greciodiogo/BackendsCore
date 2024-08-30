package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.time.LocalDate;

import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil._domain.EstadoCivil;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.generos._domain.Generos;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.identidade._domain.Identidade;
import com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.nacionalidade._repositories.TipoNacionalidade;
import com.unig4telco.grecio.diogo.Backend.Modules.geografica.domain.Municipio;
import com.unig4telco.grecio.diogo.Backend.Modules.geografica.domain.Pais;
import com.unig4telco.grecio.diogo.Backend.Modules.geografica.domain.Provincia;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="clientes")
@Table(name = "clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String contribuente;
    private String telefone;
    private Integer direccao_id;
    private String direccao;
    private String email;
    private String morada;
    private String codigo_chamada;
    private Integer distrito_id;
    private String facebook;
    private String numero_whatsapp;
    private String observacao;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    private String aprovacao_documentacao;
    private String origem;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name="genero_id", referencedColumnName = "id")
    private Generos genero;

    @ManyToOne
    @JoinColumn(name="estado_civil_id", referencedColumnName = "id")
    private EstadoCivil estado_civil;

    @ManyToOne
    @JoinColumn(name="tipo_cliente_id", referencedColumnName = "id")
    private TipoCliente tipo_cliente;
    
    @ManyToOne
    @JoinColumn(name="tipo_nacionalidade_id", referencedColumnName = "id")
    private TipoNacionalidade tipo_nacionalidade;
    
    @ManyToOne
    @JoinColumn(name="identidade_id", referencedColumnName = "id")
    private Identidade identidade;


    @ManyToOne
    @JoinColumn(name="pais_id", referencedColumnName = "id")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name="provincia_id", referencedColumnName = "id")
    private Provincia provincia;

    @ManyToOne
    @JoinColumn(name="municipio_id", referencedColumnName = "id")
    private Municipio municipio;

    private Integer user_id;
    
}
