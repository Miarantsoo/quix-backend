package com.quix.app.patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> 
{
    List<Patient> findByNom(String nom);
    Patient findByNumeroMatricule(long matricule);
    List<Patient> findByIdParrain(int idParrain);
}
