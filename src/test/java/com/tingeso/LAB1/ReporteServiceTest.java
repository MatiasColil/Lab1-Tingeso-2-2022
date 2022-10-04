package com.tingeso.LAB1;

import com.tingeso.LAB1.entities.AutorizacionEntity;
import com.tingeso.LAB1.entities.EmpleadoEntity;
import com.tingeso.LAB1.entities.EntradasEntity;
import com.tingeso.LAB1.entities.JustificativoEntity;
import com.tingeso.LAB1.services.ReporteService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ReporteServiceTest {

    @Autowired
    ReporteService reporte = new ReporteService();

    @Autowired
    EmpleadoEntity empleado = new EmpleadoEntity();

    @Autowired
    EntradasEntity entradas = new EntradasEntity();

    @Autowired
    AutorizacionEntity autorizacion = new AutorizacionEntity();

    @Autowired
    JustificativoEntity justificativo = new JustificativoEntity();

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
    void testCalcularAniosServicio(){
        int anios = 72;
        double sueldo = 1700000;
        double beneficio = reporte.calculoAniosServicio(anios,sueldo);
        assertEquals(289000,beneficio,0.0);
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

    @Test
    void testDiasNoTrabajados(){
        ArrayList<EntradasEntity> arreglo = new ArrayList<>();
        empleado.setRut("11.526.895-9");
        entradas.setRut("11.526.895-9");
        arreglo.add(entradas);
        int diasNoTrabajados=reporte.diasNoTrabajados(empleado,arreglo);
        assertEquals(29,diasNoTrabajados,0.0);
    }

    @Test
    void testVerificacionHorasExtras(){
        ArrayList<AutorizacionEntity> autorizaciones = new ArrayList<>();
        empleado.setRut("11.526.895-9");
        autorizacion.setRut("11.526.895-9");
        autorizacion.setFecha(LocalDate.parse("2022-05-26", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        autorizaciones.add(autorizacion);
        boolean hrsExtras = reporte.verificacionHorasExtras(empleado,autorizaciones,26);
        assertTrue(hrsExtras);
    }

    @Test
    void testVerificacionJustificativo(){
        ArrayList<JustificativoEntity> justicativos = new ArrayList<>();
        empleado.setRut("11.526.895-9");
        justificativo.setRut("11.526.895-9");
        justificativo.setFecha(LocalDate.parse("2022-05-26", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        justicativos.add(justificativo);
        boolean justificativo = reporte.verificacionJustificativo(empleado,justicativos,26);
        assertFalse(justificativo);
    }


    @Test
    void testCalcularSueldo(){
        //empleado
        empleado.setApellidos("Chavez");
        empleado.setNombres("lucard");
        empleado.setCategoria("A");
        LocalDate a = LocalDate.of(1950,5,25);
        LocalDate b = LocalDate.of(1920, 5,25);
        empleado.setIngresoEmpresa(a);
        empleado.setFechaNacimiento(b);
        empleado.setRut("11.526.895-9");

        //entradas
        ArrayList<EntradasEntity> arreglo = new ArrayList<>();
        entradas.setRut("11.526.895-9");
        entradas.setAnioTrabajo(2022);
        entradas.setDiaTrabajo(26);
        entradas.setMesTrabajo(5);
        entradas.setHoraIngreso(480);
        entradas.setHoraSalida(1140);
        arreglo.add(entradas);

        //justificativo
        ArrayList<JustificativoEntity> justicativos = new ArrayList<>();
        justificativo.setRut("11.526.895-9");
        justificativo.setFecha(LocalDate.parse("2022-05-28", DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        //autorizacion
        ArrayList<AutorizacionEntity> autorizaciones = new ArrayList<>();
        autorizacion.setRut("11.526.895-9");
        autorizacion.setFecha(LocalDate.parse("2022-05-30", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        autorizaciones.add(autorizacion);

        List<Double> sueldos = reporte.calcularSueldo(empleado, arreglo, justicativos, autorizaciones);

        List<Double> sueldosCorrectos = new ArrayList<>();
        sueldosCorrectos.add((double)1700000);
        sueldosCorrectos.add((double)289000);
        sueldosCorrectos.add((double)0);
        sueldosCorrectos.add((double)7701000);
        sueldosCorrectos.add((double)1989000);
        sueldosCorrectos.add((double)170000);
        sueldosCorrectos.add((double)136000);
        sueldosCorrectos.add((double)-5712000);

        assertEquals(sueldos,sueldosCorrectos);
    }


}
