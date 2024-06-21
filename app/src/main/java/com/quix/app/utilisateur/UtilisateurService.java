package com.quix.app.utilisateur;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> findByEmailAndMdp(String email , String mdp){
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmailAndMdp(email, mdp);
        return utilisateur;
    }

    public Optional<Utilisateur> findByIdUtilisateur(Long idUtilisateur){
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByIdUtilisateur(idUtilisateur);
        return utilisateur;
    }
}
