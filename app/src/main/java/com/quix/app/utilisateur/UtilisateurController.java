package com.quix.app.utilisateur;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.quix.app.misajour.MiseAJour;
import com.quix.app.misajour.MiseAJourService;


@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private MiseAJourService miseajourService;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginUtilisateur";
    }

    @PostMapping("/login")
    public Utilisateur login(@RequestParam("email") String email, @RequestParam("mdp") String mdp) {
        Optional<Utilisateur> utilisateur = utilisateurService.findByEmailAndMdp(email, mdp);
        if(utilisateur.isPresent()){
            // return utilisateur.get();
            Utilisateur utilisateur2 = utilisateur.get();
            Optional<MiseAJour> miseajour = miseajourService.findByUtilisateur(utilisateur2.getIdUtilisateur());
            utilisateur2.setFirstLog(!miseajour.isPresent());
            return utilisateur2;
        }
        return null;
    }
}
