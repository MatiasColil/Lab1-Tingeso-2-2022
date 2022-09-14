package com.tingeso.LAB1.services;

import com.tingeso.LAB1.entities.DatosEntity;
import com.tingeso.LAB1.entities.EntradasEntity;
import com.tingeso.LAB1.repositories.EntradasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EntradasService {


    @Autowired
    EntradasRepository entradasRepository;

    public List<EntradasEntity> resultadoConsulta(){
        return  (List<EntradasEntity>) entradasRepository.reordenarDatos();
    }
    public EntradasEntity guardarDatos(EntradasEntity dt){
        return entradasRepository.save(dt);
    }
}
