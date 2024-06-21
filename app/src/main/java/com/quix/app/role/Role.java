package com.quix.app.role;

import jakarta.persistence.*;

@Entity
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
    @Column(name = "idRole")
    private Long idRole;

    @Column(name = "type", nullable = false)
    private String type;

    // Getters and setters
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

