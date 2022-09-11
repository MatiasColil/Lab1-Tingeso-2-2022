package com.tingeso.LAB1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Entradas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Long id;
    private int diaTrabajo;
    private int mesTrabajo;
    private int anioTrabajo;
    private int horaIngreso;
    private int horaSalida;

    private String rut;
}
