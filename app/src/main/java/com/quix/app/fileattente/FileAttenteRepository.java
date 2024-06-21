package com.quix.app.fileattente;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FileAttenteRepository extends JpaRepository<FileAttente, Long> {
    
    @Modifying
    @Transactional
    @Query("UPDATE FileAttente f SET f.dateFin = :dateFin WHERE f.idFile = :idFile")
    void addDateFinToFile(@Param("idFile") Long idFile, @Param("dateFin") LocalDateTime dateFin);

    @Query("SELECT u FROM FileAttente u WHERE u.idFile = :idFile")
    Optional<FileAttente> findByIdFile(@Param("idFile") Long idFile);

    @Query("SELECT MAX(f.numeroFile) FROM FileAttente f")
    Long findMaxNumeroFile();
}
