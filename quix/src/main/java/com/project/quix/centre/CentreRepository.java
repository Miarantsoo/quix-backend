package com.project.quix.centre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface CentreRepository extends JpaRepository<Centre, Long> {

    @Query(value = "SELECT * FROM centre", nativeQuery = true)
    List<Centre> findAllCentres();
}