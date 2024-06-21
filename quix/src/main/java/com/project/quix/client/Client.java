package com.project.quix.client;

import com.project.quix.parrainage.Parrainage;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "client")
@Table(name = "patient")
public class Client {

    @Id
    @SequenceGenerator(
            name = "matricule_sequence",
            sequenceName = "numero_matricule_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "numero_matricule_sequence"
    )
    @Column(name = "num_matricule")
    private Long numeroMatricule;

    @Column(
            name = "nom",
            nullable = false
    )
    private String nom;

    @Column(
            name = "prenom",
            nullable = false
    )
    private String prenom;

    @Column(
            name = "sexe",
            nullable = false
    )
    private int sexe;

    @Column(
            name = "adresse",
            nullable = false
    )
    private String adresse;

    @Column(
            name = "date_naissance",
            nullable = false
    )
    private LocalDate dateNaissance;

    @Column(
            name = "lieu_naissance",
            nullable = false
    )
    private String lieuNaissance;

    @Column(
            name = "cin"
    )
    private Long CIN;

    @Column(
            name = "date_cin"
    )
    private LocalDate dateCIN;

    @Column(
            name = "lieu_cin"
    )
    private String lieuCIN;

    @Column(
            name = "email"
    )
    private String email;

    @Column(
            name = "num_telephone"
    )
    private String numeroTelephone;

    @Column(
            name = "profession"
    )
    private String profession;

    @Column(
            name = "societe"
    )
    private String societe;

    @ManyToOne
    @JoinColumn(
            name = "matricule_parrain",
            referencedColumnName = "num_matricule"
    )
    private Client parrain;

    @OneToMany(
            mappedBy = "parrain",
            cascade = CascadeType.ALL
    )
    private Set<Client> parrainees = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "type_parrainage", referencedColumnName = "id_parrainage")
    private Parrainage typeParrainage;

    @Column(name = "type_client")
    private int typeClient;

    public Client() {}

    public Client(Long numeroMatricule, String nom, String prenom, int sexe, String adresse, LocalDate dateNaissance, String lieuNaissance, Long CIN, LocalDate dateCIN, String lieuCIN, String email, String numeroTelephone, String profession, String societe, Client parrain, Parrainage typeParrainage, int typeClient) {
        this.numeroMatricule = numeroMatricule;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.CIN = CIN;
        this.dateCIN = dateCIN;
        this.lieuCIN = lieuCIN;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
        this.profession = profession;
        this.societe = societe;
        this.parrain = parrain;
        this.typeParrainage = typeParrainage;
        this.typeClient = typeClient;
    }

    public Client(String nom, String prenom, int sexe, String adresse, LocalDate dateNaissance, String lieuNaissance, Long CIN, LocalDate dateCIN, String lieuCIN, String email, String numeroTelephone, String profession, String societe, Client parrain, Set<Client> parrainees, Parrainage typeParrainage, int typeClient) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.CIN = CIN;
        this.dateCIN = dateCIN;
        this.lieuCIN = lieuCIN;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
        this.profession = profession;
        this.societe = societe;
        this.parrain = parrain;
        this.parrainees = parrainees;
        this.typeParrainage = typeParrainage;
        this.typeClient = typeClient;
    }

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

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
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

    public Long getCIN() {
        return CIN;
    }

    public void setCIN(Long CIN) {
        this.CIN = CIN;
    }

    public LocalDate getDateCIN() {
        return dateCIN;
    }

    public void setDateCIN(LocalDate dateCIN) {
        this.dateCIN = dateCIN;
    }

    public String getLieuCIN() {
        return lieuCIN;
    }

    public void setLieuCIN(String lieuCIN) {
        this.lieuCIN = lieuCIN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
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

    public Client getParrain() {
        return parrain;
    }

    public void setParrain(Client parrain) {
        this.parrain = parrain;
    }

    public Set<Client> getParrainees() {
        return parrainees;
    }

    public void setParrainees(Set<Client> parrainees) {
        this.parrainees = parrainees;
    }

    public Parrainage getTypeParrainage() {
        return typeParrainage;
    }

    public void setTypeParrainage(Parrainage typeParrainage) {
        this.typeParrainage = typeParrainage;
    }

    public int getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(int typeClient) {
        this.typeClient = typeClient;
    }
}
