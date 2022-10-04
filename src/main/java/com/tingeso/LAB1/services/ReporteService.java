package com.tingeso.LAB1.services;

import com.tingeso.LAB1.entities.*;
import com.tingeso.LAB1.repositories.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class ReporteService {

    @Autowired
    ReporteRepository reporteRepository;

    public List<Double> calcularSueldo(EmpleadoEntity empleado, List<EntradasEntity> entradas, List<JustificativoEntity> justificativos, List<AutorizacionEntity> autorizaciones){

        List<Double> dineros = new ArrayList<>();
        double sueldo=0;
        double sueldoBruto=0;
        double descuentosIngreso=0;
        double cotizacionPrev = 0;
        double cotizacionSalud=0;
        double bonificacionAnios=0;
        double bonificacionHrsExtras=0;
        double sueldoFijoEmpleado=0;

        if (empleado.getCategoria().equals("A")) {
            double sueldoFijo = 1700000;
            sueldoFijoEmpleado = sueldoFijo;
            sueldoBruto = sueldoBruto + sueldoFijo +calculoAniosServicio(aniosServicio(empleado),sueldoFijo);
            sueldo = sueldo + sueldoFijo + calculoAniosServicio(aniosServicio(empleado),sueldoFijo) - sueldoFijo*0.1 - sueldoFijo*0.08 - descuentoDiasNoTrabajados(diasNoTrabajados(empleado,entradas),sueldoFijo);
            cotizacionPrev = cotizacionPrev + sueldoFijo*0.1;
            cotizacionSalud=cotizacionSalud+sueldoFijo*0.08;
            bonificacionAnios=calculoAniosServicio(aniosServicio(empleado),sueldoFijo);
            descuentosIngreso = descuentosIngreso + sueldoFijo*0.1 + sueldoFijo*0.08 + descuentoDiasNoTrabajados(diasNoTrabajados(empleado,entradas),sueldoFijo);

            for (int j=0;j<entradas.size();j++){
                if (Objects.equals(empleado.getRut(), entradas.get(j).getRut())){
                    //calculo de descuentos
                    if (entradas.get(j).getHoraIngreso()>=491 && entradas.get(j).getHoraIngreso()<505){
                        descuentosIngreso=descuentosIngreso+sueldoFijo*0.01;
                        sueldo = sueldo - sueldoFijo*0.01;
                    } else if (entradas.get(j).getHoraIngreso()>=506 && entradas.get(j).getHoraIngreso()<525) {
                        descuentosIngreso=descuentosIngreso+sueldoFijo*0.03;
                        sueldo = sueldo - sueldoFijo*0.03;
                    } else if (entradas.get(j).getHoraIngreso()>=526 && entradas.get(j).getHoraIngreso()<550) {
                        descuentosIngreso=descuentosIngreso+sueldoFijo*0.06;
                        sueldo = sueldo - sueldoFijo*0.06;
                    } else if (entradas.get(j).getHoraIngreso()>=551 && entradas.get(j).getHoraIngreso()<700) {
                        if (verificacionJustificativo(empleado, justificativos, entradas.get(j).getDiaTrabajo())){
                            descuentosIngreso=descuentosIngreso+sueldoFijo*0.15;
                            sueldo = sueldo - sueldoFijo*0.15;
                        }
                    }
                    //calculo de horas extras
                    if (entradas.get(j).getHoraSalida()>1080){
                        int horasExtras = (entradas.get(j).getHoraSalida()-1080)/60;
                        if (verificacionHorasExtras(empleado, autorizaciones, entradas.get(j).getDiaTrabajo())){
                            sueldoBruto = sueldoBruto + horasExtras*25000;
                            sueldo = sueldo + horasExtras*25000;
                            bonificacionHrsExtras=bonificacionHrsExtras + horasExtras*25000;
                        }
                    }
                }
            }
        }
        else if (empleado.getCategoria().equals("B")) {
            double sueldoFijo = 1200000;
            sueldoFijoEmpleado = sueldoFijo;
            sueldoBruto = sueldoBruto + sueldoFijo +calculoAniosServicio(aniosServicio(empleado),sueldoFijo);
            sueldo = sueldo + sueldoFijo +calculoAniosServicio(aniosServicio(empleado),sueldoFijo) - sueldoFijo*0.1 - sueldoFijo*0.08 -descuentoDiasNoTrabajados(diasNoTrabajados(empleado,entradas),sueldoFijo);
            cotizacionPrev = cotizacionPrev + sueldoFijo*0.1;
            cotizacionSalud=cotizacionSalud+sueldoFijo*0.08;
            bonificacionAnios=calculoAniosServicio(aniosServicio(empleado),sueldoFijo);
            descuentosIngreso = descuentosIngreso + sueldoFijo*0.1 + sueldoFijo*0.08 + descuentoDiasNoTrabajados(diasNoTrabajados(empleado,entradas),sueldoFijo);

            for (int j=0;j<entradas.size();j++){
                if (Objects.equals(empleado.getRut(), entradas.get(j).getRut())){
                    //calculo de descuentos
                    if (entradas.get(j).getHoraIngreso()>=491 && entradas.get(j).getHoraIngreso()<505){
                        descuentosIngreso=descuentosIngreso+sueldoFijo*0.01;
                        sueldo = sueldo - sueldoFijo*0.01;
                    } else if (entradas.get(j).getHoraIngreso()>=506 && entradas.get(j).getHoraIngreso()<525) {
                        descuentosIngreso=descuentosIngreso+sueldoFijo*0.03;
                        sueldo = sueldo - sueldoFijo*0.03;
                    } else if (entradas.get(j).getHoraIngreso()>=526 && entradas.get(j).getHoraIngreso()<550) {
                        descuentosIngreso=descuentosIngreso+sueldoFijo*0.06;
                        sueldo = sueldo - sueldoFijo*0.06;
                    } else if (entradas.get(j).getHoraIngreso()>=551 && entradas.get(j).getHoraIngreso()<700) {
                        if (verificacionJustificativo(empleado, justificativos, entradas.get(j).getDiaTrabajo())){
                            descuentosIngreso=descuentosIngreso+sueldoFijo*0.15;
                            sueldo = sueldo - sueldoFijo*0.15;
                        }
                    }
                    //calculo de horas extras
                    if (entradas.get(j).getHoraSalida()>1080){
                        int horasExtras = (entradas.get(j).getHoraSalida()-1080)/60;
                        if (verificacionHorasExtras(empleado, autorizaciones, entradas.get(j).getDiaTrabajo())){
                            sueldoBruto = sueldoBruto + horasExtras*20000;
                            sueldo = sueldo + horasExtras*20000;
                            bonificacionHrsExtras=bonificacionHrsExtras +horasExtras*20000;
                        }
                    }
                }
            }
        }
        else if (empleado.getCategoria().equals("C")) {
            double sueldoFijo = 800000;
            sueldoFijoEmpleado = sueldoFijo;
            sueldoBruto = sueldoBruto + sueldoFijo +calculoAniosServicio(aniosServicio(empleado),sueldoFijo);
            sueldo = sueldo + sueldoFijo +calculoAniosServicio(aniosServicio(empleado),sueldoFijo) - sueldoFijo*0.1 - sueldoFijo*0.08 -descuentoDiasNoTrabajados(diasNoTrabajados(empleado,entradas),sueldoFijo);
            cotizacionPrev = cotizacionPrev + sueldoFijo*0.1;
            cotizacionSalud=cotizacionSalud+sueldoFijo*0.08;
            bonificacionAnios=calculoAniosServicio(aniosServicio(empleado),sueldoFijo);
            descuentosIngreso = descuentosIngreso + sueldoFijo*0.1 + sueldoFijo*0.08 + descuentoDiasNoTrabajados(diasNoTrabajados(empleado,entradas),sueldoFijo);

            for (int j=0;j<entradas.size();j++){
                if (Objects.equals(empleado.getRut(), entradas.get(j).getRut())){
                    //calculo de descuentos
                    if (entradas.get(j).getHoraIngreso()>=491 && entradas.get(j).getHoraIngreso()<505){
                        descuentosIngreso=descuentosIngreso+sueldoFijo*0.01;
                        sueldo = sueldo - sueldoFijo*0.01;
                    } else if (entradas.get(j).getHoraIngreso()>=506 && entradas.get(j).getHoraIngreso()<525) {
                        descuentosIngreso=descuentosIngreso+sueldoFijo*0.03;
                        sueldo = sueldo - sueldoFijo*0.03;
                    } else if (entradas.get(j).getHoraIngreso()>=526 && entradas.get(j).getHoraIngreso()<550) {
                        descuentosIngreso=descuentosIngreso+sueldoFijo*0.06;
                        sueldo = sueldo - sueldoFijo*0.06;
                    } else if (entradas.get(j).getHoraIngreso()>=551 && entradas.get(j).getHoraIngreso()<700) {
                        if (verificacionJustificativo(empleado, justificativos, entradas.get(j).getDiaTrabajo())){
                            descuentosIngreso=descuentosIngreso+sueldoFijo*0.15;
                            sueldo = sueldo - sueldoFijo*0.15;
                        }
                    }
                    //calculo de horas extras
                    if (entradas.get(j).getHoraSalida()>1080){
                        int horasExtras = (entradas.get(j).getHoraSalida()-1080)/60;
                        if (verificacionHorasExtras(empleado, autorizaciones, entradas.get(j).getDiaTrabajo())){
                            sueldoBruto = sueldoBruto + horasExtras*10000;
                            sueldo = sueldo + horasExtras*10000;
                            bonificacionHrsExtras=bonificacionHrsExtras +horasExtras*10000;
                        }
                    }
                }

            }
        }

        dineros.add(sueldoFijoEmpleado);
        dineros.add(bonificacionAnios);
        dineros.add(bonificacionHrsExtras);
        dineros.add(descuentosIngreso);
        dineros.add(sueldoBruto);
        dineros.add(cotizacionPrev);
        dineros.add(cotizacionSalud);
        dineros.add(sueldo);
        return dineros;
    }

    public int aniosServicio(EmpleadoEntity empleado){
        int anioIngreso=empleado.getIngresoEmpresa().getYear();
        int anioActual = LocalDate.now().getYear();
        return anioActual-anioIngreso;
    }

    public double calculoAniosServicio(int anios, double sueldoFijo){
        double dinero=0;
        if (anios>=5 && anios<10){
            dinero=dinero+sueldoFijo*0.05;
        } else if (anios>=10 && anios<15) {
            dinero=dinero+sueldoFijo*0.08;
        } else if (anios>=15 && anios<20) {
            dinero=dinero+sueldoFijo*0.11;
        } else if (anios>=20 && anios<25) {
            dinero=dinero+sueldoFijo*0.14;
        } else if (anios>=25) {
            dinero=dinero+sueldoFijo*0.17;
        }
        return dinero;
    }

    public int diasNoTrabajados(EmpleadoEntity empleado, List<EntradasEntity> entradas){
        int dias=0;
        int diferencia=30;
        for (int i=0;i<entradas.size();i++) {
            if (empleado.getRut().equals(entradas.get(i).getRut().trim())) {
                dias = dias + 1;
            }
        }
        return diferencia-dias;
    }
    public double descuentoDiasNoTrabajados(int dias, double sueldoFijo){
        double descuento=0;

        for (int i=0;i<dias;i++){
            descuento = descuento + sueldoFijo*0.15;
        }
        return descuento;
    }

    public boolean verificacionJustificativo(EmpleadoEntity empleado, List<JustificativoEntity> justificativo, int dia){
        for (int i=0;i<justificativo.size();i++){
            if (justificativo.get(i).getRut().equals(empleado.getRut()) && dia==justificativo.get(i).getFecha().getDayOfMonth()){
                return false;
            }
        }
        return true;
    }

    public boolean verificacionHorasExtras(EmpleadoEntity empleado, List<AutorizacionEntity> autorizacion, int dia){
        for (int i=0;i<autorizacion.size();i++){
            if (autorizacion.get(i).getRut().equals(empleado.getRut()) && dia==autorizacion.get(i).getFecha().getDayOfMonth()){
                return true;
            }
        }
        return false;
    }

    public void guardarReporteEmpleado(List<Double> dineros, EmpleadoEntity empleado){

        ReporteEntity reporte = new ReporteEntity(empleado.getRut(),empleado.getNombres() +" " +empleado.getApellidos(), empleado.getCategoria(), aniosServicio(empleado),dineros.get(0),dineros.get(1),dineros.get(2),dineros.get(3),dineros.get(4),dineros.get(5),dineros.get(6),dineros.get(7));
        reporteRepository.save(reporte);
    }

    public void iteracion(List<EmpleadoEntity> empleados, List<EntradasEntity> entradas, List<JustificativoEntity> justificativos, List<AutorizacionEntity> autorizaciones){
        for (EmpleadoEntity empleado : empleados){
            List<Double> dineros = calcularSueldo(empleado,entradas,justificativos,autorizaciones);
            guardarReporteEmpleado(dineros,empleado);
        }
    }

    public List<ReporteEntity> obtenerReportes (){
        return reporteRepository.findAll();
    }

}
