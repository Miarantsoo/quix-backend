package com.project.quix.rendezVous;

import com.project.quix.client.Client;
import com.project.quix.role.Role;
import com.project.quix.utilisateur.Utilisateur;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "rdv")
@Table(name = "rendez_vous")
public class RendezVous {

    @Id
    @SequenceGenerator(
            name = "rdv_sequence",
            sequenceName = "rdv_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rdv_sequence"
    )
    @Column(
            name = "id_rdv"
    )
    private Long idRendezVous;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private Client idPatient;

    @Column(
            name = "date_rdv",
            nullable = false,
            columnDefinition = "timestamp"
    )
    private Date dateRendezVous;

    @ManyToOne
    @JoinColumn(name = "id_medecin")
    private Utilisateur idMedecin;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    public RendezVous() {
    }

    public RendezVous(Long idRendezVous, Client idPatient, Date dateRendezVous, Utilisateur idMedecin, Role role) {
        this.idRendezVous = idRendezVous;
        this.idPatient = idPatient;
        this.dateRendezVous = dateRendezVous;
        this.idMedecin = idMedecin;
        this.role = role;
    }

    public Long getIdRendezVous() {
        return idRendezVous;
    }

    public void setIdRendezVous(Long idRendezVous) {
        this.idRendezVous = idRendezVous;
    }

    public Client getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Client idPatient) {
        this.idPatient = idPatient;
    }

    public Date getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(Date dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public Utilisateur getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Utilisateur idMedecin) {
        this.idMedecin = idMedecin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RendezVous{" +
                "idRendezVous=" + idRendezVous +
                ", idPatient=" + idPatient +
                ", dateRendezVous=" + dateRendezVous +
                ", idMedecin=" + idMedecin +
                ", role=" + role +
                '}';
    }
}
