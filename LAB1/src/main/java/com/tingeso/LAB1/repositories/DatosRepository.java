package com.tingeso.LAB1.repositories;

import com.tingeso.LAB1.entities.DatosEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DatosRepository extends CrudRepository<DatosEntity, Long> {


    @Transactional
    @Modifying
    @Query(value = "LOAD DATA LOCAL INFILE :directorio INTO TABLE datos FIELDS TERMINATED BY ';' LINES TERMINATED BY '\n' (fecha, hora, rut)", nativeQuery = true)
    public void importarDatos(@Param("directorio") String directorio);
}
