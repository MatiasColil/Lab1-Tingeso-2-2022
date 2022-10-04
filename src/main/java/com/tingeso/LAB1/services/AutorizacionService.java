package com.tingeso.LAB1.services;

import com.tingeso.LAB1.entities.AutorizacionEntity;
import com.tingeso.LAB1.repositories.AutorizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class AutorizacionService {

    @Autowired
    AutorizacionRepository autorizacionRepository;

    public AutorizacionEntity guardarAutorizacion(MultiValueMap<String,String> autorizacion){
        String rut = Objects.requireNonNull(autorizacion.getFirst("rut"));
        String fechatmp = Objects.requireNonNull(autorizacion.getFirst("fecha"));
        LocalDate fecha = LocalDate.parse(fechatmp, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return autorizacionRepository.save(new AutorizacionEntity(rut,fecha));
    }

    public List<AutorizacionEntity> obtenerAutorizaciones (){
        return autorizacionRepository.findAll();
    }
}
