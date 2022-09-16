package com.tingeso.LAB1.services;

import com.tingeso.LAB1.entities.AutorizacionEntity;
import com.tingeso.LAB1.repositories.AutorizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorizacionService {

    @Autowired
    AutorizacionRepository autorizacionRepository;

    public AutorizacionEntity guardarAutorizacion(AutorizacionEntity autorizacion){
        return autorizacionRepository.save(autorizacion);
    }
}
