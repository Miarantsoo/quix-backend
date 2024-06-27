package com.project.quix.utilisateur;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.project.quix.role.Role;
import com.project.quix.centre.Centre;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @SequenceGenerator(
        name = "utilisateur_sequence",
        sequenceName = "utilisateur_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "utilisateur_sequence"
    )
    @Column(name = "id_utilisateur")
    private Long idUtilisateur;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mdp", nullable = false)
    private String mdp;

    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "id_centre", nullable = false)
    private Centre centre;

    @Transient
    private boolean isFirstLog = false;

    // Getters and setters
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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public boolean isFirstLog() {
        return isFirstLog;
    }

    public void setFirstLog(boolean isFirstLog) {
        this.isFirstLog = isFirstLog;
    }
}
