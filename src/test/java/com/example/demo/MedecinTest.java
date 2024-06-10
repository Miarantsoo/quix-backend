package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MedecinTest {
    private Medecin medecin;

    @BeforeEach
    public void setUp() {
        medecin = new Medecin("Dr. Dupont");
        medecin.ajouterDisponibilite(LocalDateTime.of(2024, 6, 10, 9, 0), LocalDateTime.of(2024, 6, 10, 12, 0));
        medecin.ajouterDisponibilite(LocalDateTime.of(2024, 6, 10, 14, 0), LocalDateTime.of(2024, 6, 10, 17, 0));
    }

    @Test
    public void testAjouterDisponibilite() {
        assertTrue(medecin.estDisponible(LocalDateTime.of(2024, 6, 10, 9, 0), LocalDateTime.of(2024, 6, 10, 12, 0)));
        assertTrue(medecin.estDisponible(LocalDateTime.of(2024, 6, 10, 14, 0), LocalDateTime.of(2024, 6, 10, 17, 0)));
    }

    @Test
    public void testAjouterConsultationSansConflit() {
        LocalDateTime debutConsultation = LocalDateTime.of(2024, 6, 10, 10, 0);
        LocalDateTime finConsultation = LocalDateTime.of(2024, 6, 10, 11, 0);
        assertTrue(medecin.ajouterConsultation(debutConsultation, finConsultation));
    }

    @Test
    public void testAjouterConsultationAvecConflit() {
        LocalDateTime debutConsultation1 = LocalDateTime.of(2024, 6, 10, 10, 0);
        LocalDateTime finConsultation1 = LocalDateTime.of(2024, 6, 10, 11, 0);
        medecin.ajouterConsultation(debutConsultation1, finConsultation1);

        LocalDateTime debutConsultation2 = LocalDateTime.of(2024, 6, 10, 10, 30);
        LocalDateTime finConsultation2 = LocalDateTime.of(2024, 6, 10, 11, 30);
        assertFalse(medecin.ajouterConsultation(debutConsultation2, finConsultation2));
    }

    @Test
    public void testAjouterRendezVousSansConflit() {
        LocalDateTime debutRendezVous = LocalDateTime.of(2024, 6, 10, 15, 0);
        LocalDateTime finRendezVous = LocalDateTime.of(2024, 6, 10, 16, 0);
        assertTrue(medecin.ajouterRendezVous(debutRendezVous, finRendezVous));
    }

    @Test
    public void testAjouterRendezVousAvecConflit() {
        LocalDateTime debutRendezVous1 = LocalDateTime.of(2024, 6, 10, 15, 0);
        LocalDateTime finRendezVous1 = LocalDateTime.of(2024, 6, 10, 16, 0);
        medecin.ajouterRendezVous(debutRendezVous1, finRendezVous1);

        LocalDateTime debutRendezVous2 = LocalDateTime.of(2024, 6, 10, 15, 30);
        LocalDateTime finRendezVous2 = LocalDateTime.of(2024, 6, 10, 16, 30);
        assertFalse(medecin.ajouterRendezVous(debutRendezVous2, finRendezVous2));
    }
}
