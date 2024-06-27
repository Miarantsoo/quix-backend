package com.project.quix.typeconsultation;

import jakarta.persistence.*;

@Entity
@Table(name = "typeConsultation")
public class TypeConsultation {

    @Id
    @SequenceGenerator(
        name = "typeConsultation_sequence",
        sequenceName = "typeConsultation_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "typeConsultation_sequence"
    )
    @Column(name = "id_type")
    private Long idTypeConsultation;

    @Column(name = "type", nullable = false)
    private String type;

    // Getters and setters
    public Long getIdTypeConsultation() {
        return idTypeConsultation;
    }

    public void setIdTypeConsultation(Long idTypeConsultation) {
        this.idTypeConsultation = idTypeConsultation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
