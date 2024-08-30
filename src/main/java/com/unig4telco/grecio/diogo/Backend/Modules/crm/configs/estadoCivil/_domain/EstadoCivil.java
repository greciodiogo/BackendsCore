package com.unig4telco.grecio.diogo.Backend.Modules.crm.configs.estadoCivil._domain;

    import jakarta.persistence.*;
    import lombok.*;
    
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "id")
    @Entity(name="estado_civils")
    @Table(name = "estado_civils")
    public class EstadoCivil {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String nome;
        private String slug;
    
    }