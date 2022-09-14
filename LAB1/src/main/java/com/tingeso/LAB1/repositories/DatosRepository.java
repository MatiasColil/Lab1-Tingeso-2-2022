package com.tingeso.LAB1.repositories;

import com.tingeso.LAB1.entities.DatosEntity;
import com.tingeso.LAB1.entities.EntradasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


//SOLAMENTE QUERYSS
@Repository
public interface DatosRepository extends JpaRepository<DatosEntity, Long> {


    @Transactional
    @Modifying
    @Query(value = "LOAD DATA LOCAL INFILE :directorio INTO TABLE datos FIELDS TERMINATED BY ';' LINES TERMINATED BY '\n' (fecha, hora, rut)", nativeQuery = true)
    public void importarDatos(@Param("directorio") String directorio);

    @Query (value = "SELECT test.dia as dia, test.minutos as hora_ingreso, test2.minutos as hora_salida, test.rut as rut, test.año as anio, test.mes as mes FROM " +
            "(SELECT id, rut, TIME_TO_SEC(hora)/60  as minutos, DAY (fecha) as dia, MONTH (fecha) as mes, YEAR (fecha) as año from datos WHERE TIME_TO_SEC(hora)/60 > 550) as test " +
            "INNER JOIN (SELECT id, rut, TIME_TO_SEC(hora)/60  as minutos  from datos WHERE TIME_TO_SEC(hora)/60 < 550) as test2 " +
            "ON test.rut=test2.rut",nativeQuery = true)
    List<Map<String,Object>> reordenarDatos();

    @Query(value = "SELECT MONTH(fecha),rut, hora from datos where TIME_TO_SEC(hora)/60 >550",nativeQuery = true)
    List<Map<String,Object>> probandoQuery();


}
