package com.project.quix.utilisateur;

import java.util.List;
import java.util.Optional;

import com.project.quix.security.JwtUtil;
import com.project.quix.tierces.Login;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.quix.misajour.MiseAJour;
import com.project.quix.misajour.MiseAJourService;


@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private MiseAJourService miseajourService;

    private final JwtUtil jwtUtil;

    public UtilisateurController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurService.getAllUtilisateurs();
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody Login login) {
        return "{\"token\":\""+utilisateurService.authenticate(login.getEmail(), login.getMdp())+"\"}";
    }

    @GetMapping("/get-role")
    @ResponseBody
    public String getUserRole(@RequestHeader("Authorization") String token) {
        try {
            Claims claims = jwtUtil.validateToken(token.replace("Bearer ", ""));
            Utilisateur user = utilisateurService.findByEmail(claims.getSubject());
            String result = utilisateurService.getRole(user);
            return "{\"role\":\""+result+"\"}";
        } catch (Exception e) {
            throw new RuntimeException("Token is invalid.", e);
        }
    }

    @GetMapping("/get-user")
    public Utilisateur getUser(@RequestHeader("Authorization") String token){
        try {
            Claims claims = jwtUtil.validateToken(token.replace("Bearer ", ""));
            return utilisateurService.findByEmailOpt(claims.getSubject());
        } catch (Exception e) {
            return null;
        }
    }
}
