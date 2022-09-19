package com.tingeso.LAB1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Autorizacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorizacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String rut;
    private LocalDate fecha;

    public AutorizacionEntity(String rut, LocalDate fecha) {
        this.rut = rut;
        this.fecha = fecha;
    }
}
