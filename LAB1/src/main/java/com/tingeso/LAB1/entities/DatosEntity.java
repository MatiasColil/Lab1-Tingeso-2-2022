package com.tingeso.LAB1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "Datos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DatosEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private LocalDate fecha;
    private LocalTime hora;
    private String rut;

    public DatosEntity(LocalDate fecha, LocalTime hora, String rut) {
        this.fecha = fecha;
        this.hora = hora;
        this.rut = rut;
    }
}
