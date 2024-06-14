package com.quix.app.misajour;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MiseAJourRepository extends JpaRepository<MiseAJour, Long> {
    @Query("SELECT u FROM MiseAJour u WHERE u.utilisateur.idUtilisateur = :id_utilisateur")
    Optional<MiseAJour> findByUtilisateur(@Param("id_utilisateur") Long id_utilisateur);
}