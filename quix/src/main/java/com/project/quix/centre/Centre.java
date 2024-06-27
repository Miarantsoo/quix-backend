package com.project.quix.centre;

import jakarta.persistence.*;

@Entity
@Table(name = "centre")
public class Centre {

    @Id
    @SequenceGenerator(
        name = "centre_sequence",
        sequenceName = "centre_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "centre_sequence"
    )
    @Column(name = "id_centre")
    private Long idCentre;

    @Column(name = "nom", nullable = false)
    private String nom;

    public Long getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(Long idCentre) {
        this.idCentre = idCentre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

