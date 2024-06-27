package com.project.quix.rendezVous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    @Query(value = "SELECT * FROM rendez_vous WHERE date_rdv BETWEEN :date1 AND :date2",nativeQuery = true)
    List<RendezVous> findRdvBetween(@Param("date1") LocalDateTime date1,@Param("date2") LocalDateTime date2);
}
