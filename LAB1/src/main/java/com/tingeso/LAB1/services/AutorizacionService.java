package com.tingeso.LAB1.services;

import com.tingeso.LAB1.entities.AutorizacionEntity;
import com.tingeso.LAB1.repositories.AutorizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class AutorizacionService {

    @Autowired
    AutorizacionRepository autorizacionRepository;

    public AutorizacionEntity guardarAutorizacion(MultiValueMap autorizacion){
        String rut = Objects.requireNonNull(autorizacion.getFirst("rut")).toString();
        String fechatmp = Objects.requireNonNull(autorizacion.getFirst("fecha")).toString();
        LocalDate fecha = LocalDate.parse(fechatmp, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return autorizacionRepository.save(new AutorizacionEntity(rut,fecha));
    }

    public ArrayList<AutorizacionEntity> obtenerAutorizaciones (){
        return (ArrayList<AutorizacionEntity>) autorizacionRepository.findAll();
    }
}
