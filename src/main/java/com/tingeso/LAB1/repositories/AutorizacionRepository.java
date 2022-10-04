package com.tingeso.LAB1.repositories;

import com.tingeso.LAB1.entities.AutorizacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorizacionRepository extends JpaRepository<AutorizacionEntity, Long> {

}
