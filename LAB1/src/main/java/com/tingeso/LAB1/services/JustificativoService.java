package com.tingeso.LAB1.services;

import com.tingeso.LAB1.entities.AutorizacionEntity;
import com.tingeso.LAB1.entities.JustificativoEntity;
import com.tingeso.LAB1.repositories.JustificativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JustificativoService {

    @Autowired
    JustificativoRepository justificativoRepository;

    public JustificativoEntity guardarJustificativo (JustificativoEntity justificativo){
        return justificativoRepository.save(justificativo);
    }

    public ArrayList<JustificativoEntity> obtenerJustificativos (){
        return (ArrayList<JustificativoEntity>) justificativoRepository.findAll();
    }
}
