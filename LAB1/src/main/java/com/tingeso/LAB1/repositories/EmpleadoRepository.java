package com.tingeso.LAB1.repositories;

import com.tingeso.LAB1.entities.EmpleadoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoEntity, Long> {
}
