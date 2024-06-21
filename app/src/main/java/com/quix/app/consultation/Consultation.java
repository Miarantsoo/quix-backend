package com.quix.app.consultation;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consultation")
public class Consultation {

    @Id    
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "consultation_seq"
    )
    @SequenceGenerator(
        name = "consultation_seq", 
        sequenceName = "consultation_sequence", 
        allocationSize = 1
    )
    @Column(name = "idConsultation")
    private Long idConsultation;

    @Column(name = "idPatient", nullable = false)
    private Long idPatient;

    @Column(name = "idMedecin", nullable = false)
    private Long idMedecin;

    @Column(name = "typeConsultation", nullable = false)
    private Long typeConsultation;

    @Column(name = "dateDebut", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;

    @Column(name = "dateFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;


    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public Long getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Long idMedecin) {
        this.idMedecin = idMedecin;
    }

    public Long getTypeConsultation() {
        return typeConsultation;
    }

    public void setTypeConsultation(Long typeConsultation) {
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
}