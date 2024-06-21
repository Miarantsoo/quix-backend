package com.quix.app.User;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "utilisateur_seq"
    )
    @SequenceGenerator(
        name = "utilisateur_seq", 
        sequenceName = "utilisateur_sequence", 
        allocationSize = 1
    )
    @Column(name = "idUtilisateur")
    private Long idUtilisateur;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "dateNaissance", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mdp", nullable = false)
    private String mdp;

    @Column(name = "idRole", nullable = false)
    private Long idRole;

    @Column(name = "idCentre", nullable = false)
    private Long idCentre;

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public Long getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(Long idCentre) {
        this.idCentre = idCentre;
    }
}

