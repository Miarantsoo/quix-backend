package com.quix.app.rendezVous;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rendez-vous")
public class RendezVous {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "rendezVous_seq"
    )
    @SequenceGenerator(
        name = "rendezVous_seq", 
        sequenceName = "rendezVous_sequence", 
        allocationSize = 1
    )
    @Column(name = "idRendezvous")
    private Long idRendezvous;

    @Column(name = "idPatient", nullable = false)
    private Long idPatient;

    @Column(name = "dateRendezvous", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateRendezvous;

    @Column(name = "consultation", nullable = false)
    private Long consultation;


    public Long getIdRendezvous() {
        return idRendezvous;
    }

    public void setIdRendezvous(Long idRendezvous) {
        this.idRendezvous = idRendezvous;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public Date getDateRendezvous() {
        return dateRendezvous;
    }

    public void setDateRendezvous(Date dateRendezvous) {
        this.dateRendezvous = dateRendezvous;
    }

    public Long getConsultation() {
        return consultation;
    }

    public void setConsultation(Long consultation) {
        this.consultation = consultation;
    }
}
