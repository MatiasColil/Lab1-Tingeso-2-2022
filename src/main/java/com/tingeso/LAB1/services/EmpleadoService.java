package com.tingeso.LAB1.services;

import com.tingeso.LAB1.entities.EmpleadoEntity;
import com.tingeso.LAB1.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/*
*
* Ejecuta la logica de la aplicacion osea
*
* */
@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public ArrayList<EmpleadoEntity> obtenerEmpleados(){
        return (ArrayList<EmpleadoEntity>) empleadoRepository.findAll();
    }

}
