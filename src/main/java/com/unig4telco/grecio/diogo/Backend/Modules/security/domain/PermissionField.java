package com.unig4telco.grecio.diogo.Backend.Modules.security.domain;


import jakarta.persistence.*;
import lombok.*;

@Table(name="permission_fields")
@Entity(name="permission_fields")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PermissionField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String slug;
    private Boolean is_deleted;
}
