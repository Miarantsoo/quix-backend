package com.quix.app.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    
    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping
    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.addUtilisateur(utilisateur);
    }
}
