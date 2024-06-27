package com.project.quix.utilisateur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email AND u.mdp = :mdp")
    Optional<Utilisateur> findByEmailAndMdp(@Param("email") String email, @Param("mdp") String mdp);

    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email")
    Utilisateur findByEmail(@Param("email") String email);

    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email")
    Optional<Utilisateur> findByEmailOpt(@Param("email") String email);

    @Query("SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :idUtilisateur")
    Optional<Utilisateur> findByIdUtilisateur(@Param("idUtilisateur") Long idUtilisateur);
}