package com.quix.app.misajour;

import jakarta.persistence.*;
import com.quix.app.utilisateur.Utilisateur;

@Entity
@Table(name = "mise_a_jour")
public class MiseAJour {

    @Id
    @SequenceGenerator(
        name = "miseAJour_sequence",
        sequenceName = "miseAJour_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "miseAJour_sequence"
    )
    @Column(name = "id_mise_a_jour")
    private Long idMisAJour;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur", nullable = false)
    private Utilisateur utilisateur;

    // Getters and setters
    public Long getIdMisAJour() {
        return idMisAJour;
    }

    public void setIdMisAJour(Long idMisAJour) {
        this.idMisAJour = idMisAJour;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}

