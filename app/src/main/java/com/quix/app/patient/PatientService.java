package com.quix.app.patient;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService 
{
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findByNom(String nom)
    {
        return patientRepository.findByNom(nom);
    }

    public Patient findByMatricule(long matricule)
    {
        return patientRepository.findByNumeroMatricule(matricule);
    }

    public List<Patient> findFamille(int idParrain)
    {
        return patientRepository.findByIdParrain(idParrain);
    }
}