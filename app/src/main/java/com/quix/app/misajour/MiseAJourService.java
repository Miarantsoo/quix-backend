package com.quix.app.misajour;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiseAJourService {

    @Autowired
    private MiseAJourRepository miseAJourRepository;

    public List<MiseAJour> getAllMiseAJours(){
        return miseAJourRepository.findAll();
    }

    public Optional<MiseAJour> findByUtilisateur(Long utilisateur){
        Optional<MiseAJour> miseajour = miseAJourRepository.findByUtilisateur(utilisateur);
        return miseajour;
    }
}