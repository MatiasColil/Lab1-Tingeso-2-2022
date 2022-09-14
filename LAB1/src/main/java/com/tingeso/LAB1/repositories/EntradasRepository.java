package com.tingeso.LAB1.repositories;


import com.tingeso.LAB1.entities.EntradasEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface EntradasRepository extends CrudRepository<EntradasEntity, Long> {

    @Query (value = "SELECT  test.dia, test.minutos as hora_ingreso, test2.minutos as hora_salida, test.rut, test.año, test.mes FROM " +
            "(SELECT rut, TIME_TO_SEC(hora)/60  as minutos, DAY (fecha) as dia, MONTH (fecha) as mes, YEAR (fecha) as año from datos WHERE TIME_TO_SEC(hora)/60 > 550) as test " +
            "INNER JOIN (SELECT rut, TIME_TO_SEC(hora)/60  as minutos  from datos WHERE TIME_TO_SEC(hora)/60 < 550) as test2 " +
            "ON test.rut=test2.rut",nativeQuery = true)
    EntradasEntity reordenarDatos();

}
