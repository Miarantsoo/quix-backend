package com.quix.app.UserAllCenter;


import com.quix.app.User.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userAllCenter")
public class UserAllCenterController {
    
    @Autowired
    private UserAllCenterService userAllCenterService;

    @PostMapping("/all-centres")
    public void createUtilisateurForAllCentres(@RequestBody Utilisateur utilisateur) {
        userAllCenterService.createUtilisateurForAllCentres(utilisateur);
    }
}
