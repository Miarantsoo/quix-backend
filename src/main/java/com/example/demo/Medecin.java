package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Medecin {
    private String nom;
    private List<Creneau> disponibilites;
    private List<Creneau> consultations;

    public Medecin(String nom) {
        this.nom = nom;
        this.disponibilites = new ArrayList<>();
        this.consultations = new ArrayList<>();
    }
  
    public void ajouterDisponibilite(LocalDateTime debut, LocalDateTime fin) {
        Creneau nouveauCreneau = new Creneau(debut, fin);
        disponibilites.add(nouveauCreneau);
    }

    public boolean estDisponible(LocalDateTime debut, LocalDateTime fin) {
        for (Creneau creneau : disponibilites) {
            if (creneau.chevauche(debut, fin)) {
                return true;
            }
        }
        return false;
    }

    public boolean ajouterConsultation(LocalDateTime debut, LocalDateTime fin) {
        if (!estDisponible(debut, fin)) {
            System.out.println("Le médecin n'est pas disponible pour ce créneau.");
            return false;
        }

        for (Creneau consultation : consultations) {
            if (consultation.chevauche(debut, fin)) {
                System.out.println("Il y a déjà une consultation prévue pour ce créneau.");
                return false;
            }
        }
 
        consultations.add(new Creneau(debut, fin));
        System.out.println("Consultation ajoutée avec succès.");
        return true;
    }

    public boolean ajouterRendezVous(LocalDateTime debut, LocalDateTime fin) {
        return ajouterConsultation(debut, fin);
    }

    private class Creneau {
        private LocalDateTime debut;
        private LocalDateTime fin;

        public Creneau(LocalDateTime debut, LocalDateTime fin) {
            this.debut = debut;
            this.fin = fin;
        }

        public boolean chevauche(LocalDateTime debut, LocalDateTime fin) {
            return (this.debut.isBefore(fin) && this.fin.isAfter(debut));
        }
    }
}
