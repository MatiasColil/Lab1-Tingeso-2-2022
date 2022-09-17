package com.tingeso.LAB1.services;

import com.tingeso.LAB1.entities.AutorizacionEntity;
import com.tingeso.LAB1.entities.EmpleadoEntity;
import com.tingeso.LAB1.entities.EntradasEntity;
import com.tingeso.LAB1.entities.JustificativoEntity;
import com.tingeso.LAB1.repositories.ReporteRepository;
import org.hibernate.criterion.BetweenExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


@Service
public class ReporteService {


    public ArrayList<Double> calcularSueldo(EmpleadoEntity empleado, ArrayList<EntradasEntity> entradas, ArrayList<JustificativoEntity> justificativos, ArrayList<AutorizacionEntity> autorizaciones){

        ArrayList<Double> dineros = new ArrayList<>();
        double sueldo=0;
        double sueldoBruto=0;
        double descuentosIngreso=0;
        double cotizacionPrev = 0;
        double cotizacionSalud=0;
        if (empleado.getCategoria().equals("A")) {
            double sueldoFijo = 1700000;
            sueldoBruto = sueldoBruto + sueldoFijo;
            sueldo = sueldo + sueldoFijo;
            cotizacionPrev = cotizacionPrev + sueldoFijo*0.1;
            cotizacionSalud=cotizacionSalud+sueldoFijo*0.08;

            for (int j=0;j<entradas.size();j++){
                if (Objects.equals(empleado.getRut(), entradas.get(j).getRut())){
                    //calculo de descuentos
                    if (entradas.get(j).getHoraIngreso()>491 && entradas.get(j).getHoraIngreso()<505){
                        descuentosIngreso=descuentosIngreso-sueldoFijo*0.01;
                        sueldo = sueldo - sueldoFijo*0.01;
                    } else if (entradas.get(j).getHoraIngreso()>506 && entradas.get(j).getHoraIngreso()<525) {
                        descuentosIngreso=descuentosIngreso-sueldoFijo*0.03;
                        sueldo = sueldo - sueldoFijo*0.03;
                    } else if (entradas.get(j).getHoraIngreso()>526 && entradas.get(j).getHoraIngreso()<550) {
                        descuentosIngreso=descuentosIngreso-sueldoFijo*0.06;
                        sueldo = sueldo - sueldoFijo*0.06;
                    } else if (entradas.get(j).getHoraIngreso()>551 && entradas.get(j).getHoraIngreso()<700) {
                        if (verificacionJustificativo(empleado, justificativos, entradas.get(j).getDiaTrabajo())){
                            descuentosIngreso=descuentosIngreso-sueldoFijo*0.15;
                            sueldo = sueldo - sueldoFijo*0.15;
                        }
                    }
                    //calculo de horas extras
                    if (entradas.get(j).getHoraSalida()>1080){
                        int horasExtras = (entradas.get(j).getHoraSalida()-1080)/60;
                        if (verificacionHorasExtras(empleado, autorizaciones, entradas.get(j).getDiaTrabajo())){
                            sueldoBruto = sueldoBruto + horasExtras*25000;
                            sueldo = sueldo + horasExtras*25000;
                        }
                    }
                }

            }
        } else if (empleado.getCategoria().equals("B")) {
            double sueldoFijo = 1200000;
            sueldoBruto = sueldoBruto + sueldoFijo;
            sueldo = sueldo + sueldoFijo;
            cotizacionPrev = cotizacionPrev + sueldoFijo*0.1;
            cotizacionSalud=cotizacionSalud+sueldoFijo*0.08;

            for (int j=0;j<entradas.size();j++){
                if (Objects.equals(empleado.getRut(), entradas.get(j).getRut())){
                    //calculo de descuentos
                    if (entradas.get(j).getHoraIngreso()>491 && entradas.get(j).getHoraIngreso()<505){
                        descuentosIngreso=descuentosIngreso-sueldoFijo*0.01;
                        sueldo = sueldo - sueldoFijo*0.01;
                    } else if (entradas.get(j).getHoraIngreso()>506 && entradas.get(j).getHoraIngreso()<525) {
                        descuentosIngreso=descuentosIngreso-sueldoFijo*0.03;
                        sueldo = sueldo - sueldoFijo*0.03;
                    } else if (entradas.get(j).getHoraIngreso()>526 && entradas.get(j).getHoraIngreso()<550) {
                        descuentosIngreso=descuentosIngreso-sueldoFijo*0.06;
                        sueldo = sueldo - sueldoFijo*0.06;
                    } else if (entradas.get(j).getHoraIngreso()>551 && entradas.get(j).getHoraIngreso()<700) {
                        if (verificacionJustificativo(empleado, justificativos, entradas.get(j).getDiaTrabajo())){
                            descuentosIngreso=descuentosIngreso-sueldoFijo*0.15;
                            sueldo = sueldo - sueldoFijo*0.15;
                        }
                    }
                    //calculo de horas extras
                    if (entradas.get(j).getHoraSalida()>1080){
                        int horasExtras = (entradas.get(j).getHoraSalida()-1080)/60;
                        if (verificacionHorasExtras(empleado, autorizaciones, entradas.get(j).getDiaTrabajo())){
                            sueldoBruto = sueldoBruto + horasExtras*20000;
                            sueldo = sueldo + horasExtras*20000;
                        }
                    }
                }

            }
            
        } else if (empleado.getCategoria().equals("C")) {
            double sueldoFijo = 800000;
            sueldoBruto = sueldoBruto + sueldoFijo;
            sueldo = sueldo + sueldoFijo;
            cotizacionPrev = cotizacionPrev + sueldoFijo*0.1;
            cotizacionSalud=cotizacionSalud+sueldoFijo*0.08;

            for (int j=0;j<entradas.size();j++){
                if (Objects.equals(empleado.getRut(), entradas.get(j).getRut())){
                    //calculo de descuentos
                    if (entradas.get(j).getHoraIngreso()>491 && entradas.get(j).getHoraIngreso()<505){
                        descuentosIngreso=descuentosIngreso-sueldoFijo*0.01;
                        sueldo = sueldo - sueldoFijo*0.01;
                    } else if (entradas.get(j).getHoraIngreso()>506 && entradas.get(j).getHoraIngreso()<525) {
                        descuentosIngreso=descuentosIngreso-sueldoFijo*0.03;
                        sueldo = sueldo - sueldoFijo*0.03;
                    } else if (entradas.get(j).getHoraIngreso()>526 && entradas.get(j).getHoraIngreso()<550) {
                        descuentosIngreso=descuentosIngreso-sueldoFijo*0.06;
                        sueldo = sueldo - sueldoFijo*0.06;
                    } else if (entradas.get(j).getHoraIngreso()>551 && entradas.get(j).getHoraIngreso()<700) {
                        if (verificacionJustificativo(empleado, justificativos, entradas.get(j).getDiaTrabajo())){
                            descuentosIngreso=descuentosIngreso-sueldoFijo*0.15;
                            sueldo = sueldo - sueldoFijo*0.15;
                        }
                    }
                    //calculo de horas extras
                    if (entradas.get(j).getHoraSalida()>1080){
                        int horasExtras = (entradas.get(j).getHoraSalida()-1080)/60;
                        if (verificacionHorasExtras(empleado, autorizaciones, entradas.get(j).getDiaTrabajo())){
                            sueldoBruto = sueldoBruto + horasExtras*10000;
                            sueldo = sueldo + horasExtras*10000;
                        }
                    }
                }

            }
        }


        dineros.add(sueldo);
        dineros.add(sueldoBruto);
        dineros.add(descuentosIngreso);
        dineros.add(cotizacionPrev);
        dineros.add(cotizacionSalud);
        return dineros;
    }

    public int aniosServicio(EmpleadoEntity empleado){
        int anioIngreso=empleado.getIngresoEmpresa().getYear();
        int anioActual = LocalDate.now().getYear();
        return anioActual-anioIngreso;
    }

    public int diasTrabajados(EmpleadoEntity empleado, ArrayList<EntradasEntity> entradas){
        int dias=0;
        int diferencia=30;

        for (EntradasEntity entrada : entradas) {
            if (entrada.getRut().equals(empleado.getRut())) {
                dias = dias + 1;
            }
        }
        return diferencia-dias;
    }

    public boolean verificacionJustificativo(EmpleadoEntity empleado, ArrayList<JustificativoEntity> justificativo, int dia){
        for (int i=0;i<justificativo.size();i++){
            if (justificativo.get(i).getRut().equals(empleado.getRut()) && dia==justificativo.get(i).getFecha().getDayOfMonth()){
                return false;
            }
        }
        return true;
    }

    public boolean verificacionHorasExtras(EmpleadoEntity empleado, ArrayList<AutorizacionEntity> autorizacion, int dia){
        for (int i=0;i<autorizacion.size();i++){
            if (autorizacion.get(i).getRut().equals(empleado.getRut()) && dia==autorizacion.get(i).getFecha().getDayOfMonth()){
                return true;
            }
        }
        return false;
    }
}
