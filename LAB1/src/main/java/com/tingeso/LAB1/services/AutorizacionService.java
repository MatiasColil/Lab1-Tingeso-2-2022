package com.tingeso.LAB1.services;

import com.tingeso.LAB1.entities.AutorizacionEntity;
import com.tingeso.LAB1.repositories.AutorizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AutorizacionService {

    @Autowired
    AutorizacionRepository autorizacionRepository;

    public AutorizacionEntity guardarAutorizacion(AutorizacionEntity autorizacion){
        return autorizacionRepository.save(autorizacion);
    }

    public ArrayList<AutorizacionEntity> obtenerAutorizaciones (){
        return (ArrayList<AutorizacionEntity>) autorizacionRepository.findAll();
    }
}
