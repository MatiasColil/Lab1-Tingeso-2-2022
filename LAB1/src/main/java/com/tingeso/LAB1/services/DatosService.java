package com.tingeso.LAB1.services;


import com.tingeso.LAB1.entities.DatosEntity;
import com.tingeso.LAB1.repositories.DatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class DatosService {

    @Autowired
    DatosRepository datosRepository;
    public void guardar(MultipartFile archivo) throws IOException {
        String datosArchivo = new String(archivo.getBytes());
        String[] splitSalto = datosArchivo.split("\n");
        List<String> splitCaracter =Arrays.stream(splitSalto).toList();
        for (int i=0;i< splitCaracter.size();i++){
            String[] separador = splitCaracter.get(i).split(";");
            LocalDate fecha = LocalDate.parse(separador[0], DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            LocalTime hora = LocalTime.parse(separador[1]);
            String rut = separador[2].trim();
            guardarDatos(new DatosEntity(fecha,hora,rut));
        }
    }

    public List<Map<String, String>> resultadoConsulta(){
        return datosRepository.reordenarDatos();
    }

    public DatosEntity guardarDatos(DatosEntity datos){
        return datosRepository.save(datos);
    }

}
