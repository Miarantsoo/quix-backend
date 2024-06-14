package com.quix.app.utilisateur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email AND u.mdp = :mdp")
    Optional<Utilisateur> findByEmailAndMdp(@Param("email") String email, @Param("mdp") String mdp);
}