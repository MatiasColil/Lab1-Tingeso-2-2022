package com.tingeso.LAB1.services;

import com.tingeso.LAB1.entities.*;
import com.tingeso.LAB1.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/*
*
* Ejecuta la logica de la aplicacion osea
*
* */
@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<EmpleadoEntity> obtenerEmpleados(){
        return  empleadoRepository.findAll();
    }

}
