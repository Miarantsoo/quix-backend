package com.quix.app.misajour;

import jakarta.persistence.*;
import com.quix.app.utilisateur.Utilisateur;

@Entity
@Table(name = "mise_a_jour")
public class MiseAJour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

