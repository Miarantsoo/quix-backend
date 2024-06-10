package com.quix.app.patient;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.openssl.pem_password_cb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins="*")
public class PatientControleur 
{
    @GetMapping("/test")
    public List<String> liste()
    {
        List<String> test=new ArrayList<>();
        test.add("test1");
        test.add("test2");
        return test;
    }

    @Autowired
    PatientService patientService;

    @GetMapping("/nom/{nom}")
    public List<Patient> getByNom(@PathVariable String nom)
    {
        return patientService.findByNom(nom);
    }

    @GetMapping("/matricule/{matricule}")
    public Patient getByNumeroMatricule(@PathVariable Long matricule)
    {
        return patientService.findByMatricule(matricule);
    }

    @GetMapping("/famille/{idParrain}")
    public List<Patient> getByIdParrain(@PathVariable int idParrain)
    {
        return patientService.findFamille(idParrain);
    }
}