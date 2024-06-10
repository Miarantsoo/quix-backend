package com.quix.app.patient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name="patient")
@Getter
@Setter
public class Patient 
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long numeroMatricule;
    String nom;
    String prenom;
    int sexe;
    String adresse;
    Date dateNaisance;
    String lieuNaissance;
    int cin;
    Date dateCin;
    int lieuCin;
    String email;
    String telephone;
    String profession;
    String societe;
    int idParrain;
}