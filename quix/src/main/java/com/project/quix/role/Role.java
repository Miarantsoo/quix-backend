package com.project.quix.role;

import jakarta.persistence.*;

@Entity(name= "role")
@Table(name = "role")
public class Role {

    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )
    @Column(
            name = "id_role",
            nullable = false
    )
    private Long idRole;
    private String type;

    public Role() {
    }

    public Role(Long idRole, String type) {
        this.idRole = idRole;
        this.type = type;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
