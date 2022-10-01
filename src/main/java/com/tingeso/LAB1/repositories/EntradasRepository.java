package com.tingeso.LAB1.repositories;


import com.tingeso.LAB1.entities.EntradasEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntradasRepository extends CrudRepository<EntradasEntity, Long> {

}
