package com.quix.app.centre;

import jakarta.persistence.*;

@Entity
@Table(name = "centre")
public class Centre {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "centre_seq"
    )

    @SequenceGenerator(
        name = "centre_seq", 
        sequenceName = "centre_sequence", 
        allocationSize = 1
    )
    @Column(name = "idCentre")
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
