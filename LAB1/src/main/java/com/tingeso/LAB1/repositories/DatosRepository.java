package com.tingeso.LAB1.repositories;

import com.tingeso.LAB1.entities.DatosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;


//SOLAMENTE QUERYSS
@Repository
public interface DatosRepository extends JpaRepository<DatosEntity, Long> {

    @Query (value = "SELECT test.dia as dia, ROUND(test.minutos) as hora_ingreso, ROUND(test2.minutos) as hora_salida, test.rut as rut, test.año as anio, test.mes as mes FROM " +
            "(SELECT id, rut, TIME_TO_SEC(hora)/60  as minutos, DAY (fecha) as dia, MONTH (fecha) as mes, YEAR (fecha) as año from datos WHERE TIME_TO_SEC(hora)/60 > 700) as test " +
            "INNER JOIN (SELECT id, rut, TIME_TO_SEC(hora)/60  as minutos, DAY(fecha) as dia  from datos WHERE TIME_TO_SEC(hora)/60 < 700) as test2 " +
            "ON test.rut=test2.rut AND test.dia=test2.dia",nativeQuery = true)
    List<Map<String, String>> reordenarDatos();

}
