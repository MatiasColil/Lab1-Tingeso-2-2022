package com.tingeso.LAB1.services;

import com.tingeso.LAB1.entities.AutorizacionEntity;
import com.tingeso.LAB1.entities.JustificativoEntity;
import com.tingeso.LAB1.repositories.JustificativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class JustificativoService {

    @Autowired
    JustificativoRepository justificativoRepository;

    public JustificativoEntity guardarJustificativo (MultiValueMap justificativo){
        String rut = Objects.requireNonNull(justificativo.getFirst("rut")).toString();
        String fechatmp = Objects.requireNonNull(justificativo.getFirst("fecha")).toString();
        LocalDate fecha = LocalDate.parse(fechatmp, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return justificativoRepository.save(new JustificativoEntity(rut,fecha));
    }

    public ArrayList<JustificativoEntity> obtenerJustificativos (){
        return (ArrayList<JustificativoEntity>) justificativoRepository.findAll();
    }
}
