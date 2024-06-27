package com.project.quix.dashboard.model;

import com.project.quix.consulation.Consultation;
import com.project.quix.rendezVous.RendezVous;

public class DashboardComponents {
    private RendezVous[] rendezVous;
    private Consultation[] consultation;

    public RendezVous[] getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(RendezVous[] rendezVous) {
        this.rendezVous = rendezVous;
    }

    public Consultation[] getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation[] consultation) {
        this.consultation = consultation;
    }
}
