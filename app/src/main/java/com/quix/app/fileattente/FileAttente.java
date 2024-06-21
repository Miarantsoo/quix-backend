package com.quix.app.fileattente;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.quix.app.patient.Patient;
import com.quix.app.utilisateur.Utilisateur;
import com.quix.app.typeconsultation.TypeConsultation;

@Entity
@Table(name = "fileAttente")
public class FileAttente {

    @Id
    @SequenceGenerator(
        name = "fileAttente_sequence",
        sequenceName = "fileAttente_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "fileAttente_sequence"
    )
    @Column(name = "idFile")
    private Long idFile;

    @Column(name = "numeroFile", nullable = false)
    private Long numeroFile;

    @ManyToOne
    @JoinColumn(name = "idPatient", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "idMedecin", nullable = false)
    private Utilisateur medecin;

    @ManyToOne
    @JoinColumn(name = "typeConsultation", nullable = false)
    private TypeConsultation typeConsultation;

    @Column(name = "dateDebut", nullable = false)
    private LocalDateTime dateDebut;

    @Column(name = "dateFin")
    private LocalDateTime dateFin;

    // Getters and setters
    public Long getIdFile() {
        return idFile;
    }

    public void setIdFile(Long idFile) {
        this.idFile = idFile;
    }

    public Long getNumeroFile() {
        return numeroFile;
    }

    public void setNumeroFile(Long numeroFile) {
        this.numeroFile = numeroFile;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Utilisateur getMedecin() {
        return medecin;
    }

    public void setMedecin(Utilisateur medecin) {
        this.medecin = medecin;
    }

    public TypeConsultation getTypeConsultation() {
        return typeConsultation;
    }

    public void setTypeConsultation(TypeConsultation typeConsultation) {
        this.typeConsultation = typeConsultation;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }
}