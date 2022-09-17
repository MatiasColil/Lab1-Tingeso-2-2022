package com.tingeso.LAB1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Reporte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private int mes;
    private int anio;
    private String rut;
    private String nombreApellido;
    private String categoria;
    private int aniosServicio;
    private double sueldoFijo;
    private double bonificacionAnios;
    private double bonificacionHrsExtras;
    private double descuentos;
    private double sueldoBruto;
    private double cotizacionPrevisional;
    private double cotizacionSalud;
    private double montoFinal;

    public ReporteEntity(int mes, int anio, String rut, String nombreApellido, String categoria, int aniosServicio, double sueldoFijo, double bonificacionAnios, double bonificacionHrsExtras, double descuentos, double sueldoBruto, double cotizacionPrevisional, double cotizacionSalud, double montoFinal) {
        this.mes = mes;
        this.anio = anio;
        this.rut = rut;
        this.nombreApellido = nombreApellido;
        this.categoria = categoria;
        this.aniosServicio = aniosServicio;
        this.sueldoFijo = sueldoFijo;
        this.bonificacionAnios = bonificacionAnios;
        this.bonificacionHrsExtras = bonificacionHrsExtras;
        this.descuentos = descuentos;
        this.sueldoBruto = sueldoBruto;
        this.cotizacionPrevisional = cotizacionPrevisional;
        this.cotizacionSalud = cotizacionSalud;
        this.montoFinal = montoFinal;
    }
}
