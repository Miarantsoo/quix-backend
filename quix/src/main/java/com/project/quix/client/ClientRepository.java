package com.project.quix.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT * FROM patient WHERE type_client = :typeClient", nativeQuery = true)
    List<Client> findClientByType(@Param(value = "typeClient") int type);

    @Query(value = "SELECT * FROM patient WHERE type_client = :typeClient and (nom ILIKE %:recherche% or prenom ILIKE %:recherche%)", nativeQuery = true)
    List<Client> searchPatientByName(@Param(value = "typeClient") int type, @Param(value = "recherche") String recherche);

}
