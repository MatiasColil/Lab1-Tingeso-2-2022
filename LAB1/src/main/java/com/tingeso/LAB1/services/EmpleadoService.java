package com.tingeso.LAB1.services;

import com.tingeso.LAB1.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;
}
