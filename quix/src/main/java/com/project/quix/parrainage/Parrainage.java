package com.project.quix.parrainage;

import jakarta.persistence.*;

@Entity(name = "parrainage")
public class Parrainage {

    @Id
    @SequenceGenerator(
            name = "parrainage_sequence",
            sequenceName = "parrainage_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "parrainage_sequence"
    )
    @Column(name = "id_parrainage")
    private Long idParrainage;
    private String type;

    public Parrainage(Long idParrainage, String type) {
        this.idParrainage = idParrainage;
        this.type = type;
    }

    public Parrainage(String type) {
        this.type = type;
    }

    public Parrainage() {

    }

    public Long getIdParrainage() {
        return idParrainage;
    }

    public void setIdParrainage(Long idParrainage) {
        this.idParrainage = idParrainage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
