package com.tingeso.LAB1.services;

import com.tingeso.LAB1.entities.EntradasEntity;
import com.tingeso.LAB1.repositories.EntradasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EntradasService {

    @Autowired
    EntradasRepository entradasRepository;

    public void guardarTest(List<Map<String, String>> test){
        for (Map<String, String> map:test) {
            Collection<String> probando = map.values();
            List<Object> list = new ArrayList<>(probando);


            int diaTrabajo = Integer.parseInt(list.get(0).toString());
            int horaSalida = Integer.parseInt(list.get(1).toString());
            int horaIngreso = Integer.parseInt(list.get(2).toString());
            String rut = list.get(3).toString();
            int anioTrabajo = Integer.parseInt(list.get(4).toString());
            int mesTrabajo = Integer.parseInt(list.get(5).toString());

            EntradasEntity nuevaEntrada = new EntradasEntity(diaTrabajo, horaIngreso, horaSalida, rut, anioTrabajo, mesTrabajo);
            entradasRepository.save(nuevaEntrada);
        }
    }

    public List<EntradasEntity> obtenerEntradas (){
        return  entradasRepository.findAll();
    }
}
