package com.tingeso.LAB1.repositories;


import com.tingeso.LAB1.entities.EntradasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntradasRepository extends JpaRepository<EntradasEntity, Long> {

}
