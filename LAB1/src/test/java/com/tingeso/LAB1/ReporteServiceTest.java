package com.tingeso.LAB1;

import com.tingeso.LAB1.entities.EmpleadoEntity;
import com.tingeso.LAB1.services.ReporteService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;


public class ReporteServiceTest {

    ReporteService reporte = new ReporteService();

    EmpleadoEntity empleado = new EmpleadoEntity();

    @Test
    void test1(){
        empleado.setApellidos("Chavez");
        empleado.setNombres("lucard");
        empleado.setCategoria("A");
        LocalDate a = LocalDate.of(1950,5,25);
        LocalDate b = LocalDate.of(1920, 5,25);
        empleado.setIngresoEmpresa(a);
        empleado.setFechaNacimiento(b);

        double numero = reporte.aniosServicio(empleado);
        assertEquals(72,numero,0.0);
    }

}
