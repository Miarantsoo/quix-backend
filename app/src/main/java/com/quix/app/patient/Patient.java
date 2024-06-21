package com.quix.app.patient;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @SequenceGenerator(
        name = "patient_sequence",
        sequenceName = "patient_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "patient_sequence"
    )
    @Column(name = "numeroMatricule")
    private Long numeroMatricule;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "sexe", nullable = false)
    private Integer sexe;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "dateNaissance", nullable = false)
    private LocalDate dateNaissance;

    @Column(name = "lieuNaissance", nullable = false)
    private String lieuNaissance;

    @Column(name = "CIN")
    private Long cin;

    @Column(name = "dateCIN")
    private LocalDate dateCIN;

    @Column(name = "lieuCIN")
    private Long lieuCIN;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "profession")
    private String profession;

    @Column(name = "societe")
    private String societe;

    @ManyToOne
    @JoinColumn(name = "idParrain")
    private Patient parrain;

    // Getters and setters
    public Long getNumeroMatricule() {
        return numeroMatricule;
    }

    public void setNumeroMatricule(Long numeroMatricule) {
        this.numeroMatricule = numeroMatricule;
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

    public Integer getSexe() {
        return sexe;
    }

    public void setSexe(Integer sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public Long getCin() {
        return cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

    public LocalDate getDateCIN() {
        return dateCIN;
    }

    public void setDateCIN(LocalDate dateCIN) {
        this.dateCIN = dateCIN;
    }

    public Long getLieuCIN() {
        return lieuCIN;
    }

    public void setLieuCIN(Long lieuCIN) {
        this.lieuCIN = lieuCIN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public Patient getParrain() {
        return parrain;
    }

    public void setParrain(Patient parrain) {
        this.parrain = parrain;
    }
}