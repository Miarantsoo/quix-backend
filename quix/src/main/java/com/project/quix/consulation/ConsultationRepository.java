package com.project.quix.consulation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    @Query(value = "SELECT * FROM consultation WHERE dateDebut BETWEEN :date1 AND :date2",nativeQuery = true )
    List<Consultation> findBetween(@Param("date1")LocalDateTime date1, @Param("date2") LocalDateTime date2);
}
