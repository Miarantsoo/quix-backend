package com.project.quix.fileattente;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.project.quix.client.Client;
import com.project.quix.utilisateur.Utilisateur;
import com.project.quix.typeconsultation.TypeConsultation;

@Entity
@Table(name = "file_attente")
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
    @Column(name = "id_file")
    private Long idFile;

    @Column(name = "numero_file", nullable = false)
    private Long numeroFile;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private Client patient;

    @ManyToOne
    @JoinColumn(name = "idMedecin", nullable = false)
    private Utilisateur medecin;

    @ManyToOne
    @JoinColumn(name = "type_consultation", nullable = false)
    private TypeConsultation typeConsultation;

    @Column(name = "date_debut", nullable = false)
    private LocalDateTime dateDebut;

    @Column(name = "date_fin")
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

    public Client getPatient() {
        return patient;
    }

    public void setPatient(Client patient) {
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