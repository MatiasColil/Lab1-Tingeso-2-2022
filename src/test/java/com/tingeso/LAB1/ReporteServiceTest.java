package com.tingeso.LAB1;

import com.tingeso.LAB1.entities.EmpleadoEntity;
import com.tingeso.LAB1.services.ReporteService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;


class ReporteServiceTest {

    @Autowired
    ReporteService reporte = new ReporteService();

    @Autowired
    EmpleadoEntity empleado = new EmpleadoEntity();


    @Test
    void testDescuentoDiasNoTrabajados(){
        double diasNoTrabajados = reporte.descuentoDiasNoTrabajados(2,800000);
        double diasNoTrabajados2 = reporte.descuentoDiasNoTrabajados(5,1700000);
        double diasNoTrabajados3 = reporte.descuentoDiasNoTrabajados(1,1200000);
        assertEquals(240000,diasNoTrabajados,0.0);
        assertEquals(1275000,diasNoTrabajados2,0.0);
        assertEquals(180000,diasNoTrabajados3,0.0);
    }

    @Test
    void testCalcularAniosSeervicio(){
        int anios = 8;
        double sueldo = 800000;
        double beneficio = reporte.calculoAniosServicio(anios,sueldo);
        assertEquals(40000,beneficio,0.0);
    }

    @Test
    void testAnioServicio(){
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
