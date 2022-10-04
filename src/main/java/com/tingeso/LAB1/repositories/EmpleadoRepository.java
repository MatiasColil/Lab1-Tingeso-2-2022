package com.tingeso.LAB1.repositories;

import com.tingeso.LAB1.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
*
* conexiones con la base de datos
*
* */
@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {
}
