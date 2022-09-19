package com.tingeso.LAB1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

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


    public EntradasEntity(int diaTrabajo, int horaIngreso, int horaSalida, String rut, int anioTrabajo, int mesTrabajo) {
        this.diaTrabajo = diaTrabajo;
        this.mesTrabajo = mesTrabajo;
        this.anioTrabajo = anioTrabajo;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.rut = rut;
    }
}
