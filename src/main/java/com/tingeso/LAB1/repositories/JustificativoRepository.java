package com.tingeso.LAB1.repositories;

import com.tingeso.LAB1.entities.JustificativoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JustificativoRepository extends JpaRepository<JustificativoEntity, Long> {
}
