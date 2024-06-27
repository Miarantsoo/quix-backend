package com.project.quix.consulation;

import com.project.quix.client.Client;
import com.project.quix.typeconsultation.TypeConsultation;
import com.project.quix.utilisateur.Utilisateur;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "consultation")
@Table(name = "consultation")
public class Consultation {

    @Id
    @SequenceGenerator(
            name = "consultation_sequence",
            sequenceName = "consultation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "consultation_sequence"
    )
    @Column(
            name = "id_consultation"
    )
    private Long idConsultation;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private Client idPatient;

    @ManyToOne
    @JoinColumn(name = "id_medecin", nullable = false)
    private Utilisateur idMedecin;

    @ManyToOne
    @JoinColumn(name = "type_consultation", nullable = false)
    private TypeConsultation typeConsultation;

    @Column(
            name = "date_debut",
            columnDefinition = "timestamp",
            nullable = false
    )
    private Date dateDebut;

    @Column(
            name = "date_fin",
            columnDefinition = "timestamp"
    )
    private Date dateFin;

    public Consultation() {
    }

    public Consultation(Long idConsultation, Client idPatient, Utilisateur idMedecin, TypeConsultation typeConsultation, Date dateDebut, Date dateFin) {
        this.idConsultation = idConsultation;
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
        this.typeConsultation = typeConsultation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }

    public Client getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Client idPatient) {
        this.idPatient = idPatient;
    }

    public Utilisateur getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Utilisateur idMedecin) {
        this.idMedecin = idMedecin;
    }

    public TypeConsultation getTypeConsultation() {
        return typeConsultation;
    }

    public void setTypeConsultation(TypeConsultation typeConsultation) {
        this.typeConsultation = typeConsultation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "idConsultation=" + idConsultation +
                ", idPatient=" + idPatient +
                ", idMedecin=" + idMedecin +
                ", typeConsultation=" + typeConsultation +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}
