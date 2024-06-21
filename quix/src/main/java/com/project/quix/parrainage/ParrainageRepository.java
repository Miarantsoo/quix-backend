package com.project.quix.parrainage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParrainageRepository extends JpaRepository<Parrainage, Long> {
}
