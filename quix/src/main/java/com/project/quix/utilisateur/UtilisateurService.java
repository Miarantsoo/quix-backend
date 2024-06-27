package com.project.quix.utilisateur;

// import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.project.quix.security.JwtUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    private final JwtUtil jwtUtil;

    public UtilisateurService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public String authenticate(String email, String mdp) {
        String hashedPass = DigestUtils.sha256Hex(mdp);
        System.out.println(hashedPass);
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByEmailAndMdp(email, hashedPass);
        if (utilisateurOptional.isPresent()) {
            Utilisateur utilisateur = utilisateurOptional.get();
            return jwtUtil.generateToken(utilisateur.getEmail());
        }
        return "Invalid email or password";
    }

    public String getRole(Utilisateur user){
        return switch (user.getRole().getType()) {
            case "Super Administrateur" -> "Super administrateur";
            case "Ressources humaines" -> "Ressources humaines";
            case "Agent d'accueil" -> "Agent d'accueil";
            default -> "Medecin";
        };
    }

    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public Utilisateur findByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public Utilisateur findByEmailOpt(String email){
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmailOpt(email);
        return utilisateur.orElse(null);
    }

    public Optional<Utilisateur> findByIdUtilisateur(Long idUtilisateur){
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByIdUtilisateur(idUtilisateur);
        return utilisateur;

    }
    public void updatePassword(Utilisateur user, String newPassword){
        System.out.println(newPassword);
        String newHashedPassword = DigestUtils.sha256Hex(newPassword);
        user.setMdp(newHashedPassword);
        utilisateurRepository.save(user);
    }
}
