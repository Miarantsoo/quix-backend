package com.project.quix.misajour;

import java.util.List;
import java.util.Optional;

import com.project.quix.security.JwtUtil;
import com.project.quix.utilisateur.Utilisateur;
import com.project.quix.utilisateur.UtilisateurService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

@Service
public class MiseAJourService {

    @Autowired
    private MiseAJourRepository miseAJourRepository;

    @Autowired
    private UtilisateurService utilisateurService;

    private final JwtUtil jwtUtil;

    public MiseAJourService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public List<MiseAJour> getAllMiseAJours(){
        return miseAJourRepository.findAll();
    }

    public Optional<MiseAJour> findByUtilisateur(Long utilisateur){
        return miseAJourRepository.findByUtilisateur(utilisateur);
    }

    public void makeUserAuthentified(String token, String newPassword){
        try {
            Claims claims = jwtUtil.validateToken(token.replace("Bearer", ""));
            Utilisateur user = utilisateurService.findByEmail(claims.getSubject());
            utilisateurService.updatePassword(user, newPassword);
            MiseAJour maj = new MiseAJour(user);
            miseAJourRepository.save(maj);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public String verifyIfAlreadyAuthentified(String token){
        try {
            Claims claims = jwtUtil.validateToken(token.replace("Bearer", ""));
            Utilisateur user = utilisateurService.findByEmail(claims.getSubject());
            Optional<MiseAJour> maj = miseAJourRepository.findByUtilisateur(user.getIdUtilisateur());
            if(maj.isPresent()){
                return "{\"verify\":\"authentified\"}";
            }
            return "{\"verify\":\"not authentified\"}";
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}