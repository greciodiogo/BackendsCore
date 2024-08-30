package com.unig4telco.grecio.diogo.Backend.Modules.crm.clientes._domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

import com.unig4telco.grecio.diogo.Backend.Modules.security.domain.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name="gestor_clientes")
@Table(name = "gestor_clientes")
public class GestorCliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String funcao; 
    private Boolean is_actived; 
    private Boolean is_deleted; 
    @ManyToOne
    @JoinColumn(name="gestor_id", referencedColumnName = "id")
    private User gestor;
    @ManyToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private Clientes cliente;
    // @ManyToOne
    // @JoinColumn(name="user_id", referencedColumnName = "id")
    // private User user;
    
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;
}