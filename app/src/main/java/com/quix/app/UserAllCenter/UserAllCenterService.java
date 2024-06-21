package com.quix.app.UserAllCenter;

import com.quix.app.User.*;
import com.quix.app.centre.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAllCenterService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private CentreRepository centreRepository;

    public void createUtilisateurForAllCentres(Utilisateur utilisateur) {
        List<Centre> centres = (List<Centre>) centreRepository.findAll(); 
        for (Centre centre : centres) {
            Utilisateur newUser = new Utilisateur();
            newUser.setNom(utilisateur.getNom());
            newUser.setPrenom(utilisateur.getPrenom());
            newUser.setDateNaissance(utilisateur.getDateNaissance());
            newUser.setAdresse(utilisateur.getAdresse());
            newUser.setEmail(utilisateur.getEmail());
            newUser.setMdp(utilisateur.getMdp());
            newUser.setIdRole(utilisateur.getIdRole());
            newUser.setIdCentre(centre.getIdCentre());
            utilisateurRepository.save(newUser);
        }
    }
}
