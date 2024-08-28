package com.unig4telco.grecio.diogo.Backend.crm.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.Date;
import java.time.LocalDate;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.*;
import com.unig4telco.grecio.diogo.Backend.geografica.domain.Municipio;
import com.unig4telco.grecio.diogo.Backend.geografica.domain.Pais;
import com.unig4telco.grecio.diogo.Backend.geografica.domain.Provincia;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="clientes")
@Table(name = "clientes")
//@Table(name = "clientes", uniqueConstraints = {
//        @UniqueConstraint(columnNames = "recibo_sigla")
//})
public class Clientes {

    public Clientes(CreateClientesDTO createClientesDTO){
        this.nome = createClientesDTO.nome();
        this.direccao = createClientesDTO.direccao();
        this.contribuente = createClientesDTO.contribuente();
        this.email = createClientesDTO.email();
        this.morada = createClientesDTO.morada();
       this.createdAt = createClientesDTO.created_at();
        this.updatedAt = createClientesDTO.updated_at();
    }

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
    
    public void updateCliente(@Valid UpdateClienteDTO jsonBody){
        if(jsonBody.nome() != null){
            this.nome = jsonBody.nome();
        }if(jsonBody.contribuente() != null){
            this.contribuente = jsonBody.contribuente();
        }if(jsonBody.telefone() != null){
            this.telefone = jsonBody.telefone();
        }if(jsonBody.email() != null){
            this.email = jsonBody.email();
        }if(jsonBody.morada() != null){
            this.morada = jsonBody.morada();
        }if(jsonBody.direccao() != null){
            this.direccao = jsonBody.direccao();
        }
    }

//    public void inactivarCliente(){
//        this.estado = this.handleStatus(false);
//    }
//
//    public void activarCliente(){
//        this.estado = this.handleStatus(true);
//    }

    public Boolean handleStatus(Boolean is_deleted){
        return is_deleted;
    }
}
