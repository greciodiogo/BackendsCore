package com.unig4telco.grecio.diogo.Backend.crm.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.Date;

import com.unig4telco.grecio.diogo.Backend.crm.DTO.*;

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
       this.created_at = createClientesDTO.created_at();
        this.updated_at = createClientesDTO.updated_at();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String contribuente;
    private String telefone;
    private String direccao;
    private String email;
    private String morada;
    private Date created_at;
    private Date updated_at;
    private String aprovacao_documentacao;
    private String origem;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name="genero_id", referencedColumnName = "id")
    private Generos genero;

    @ManyToOne
    @JoinColumn(name="estado_civil_id", referencedColumnName = "id")
    private EstadoCivil estado_civil;

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name="tipo_cliente_id", referencedColumnName = "id")
    private TipoCliente tipo_cliente;
    
    @ManyToOne
    @JoinColumn(name="tipo_nacionalidade_id", referencedColumnName = "id")
    private TipoNacionalidade tipo_nacionalidade;

=======
>>>>>>> 2b1f2cbf6f703623db71ea0317fe1361afa951c5
    private Integer identidade_id;
    private Integer pais_id;
    private Integer provincia_id;
    private Integer municipio_id;
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
