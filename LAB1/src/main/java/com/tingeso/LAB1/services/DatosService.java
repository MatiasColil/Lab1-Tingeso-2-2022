package com.tingeso.LAB1.services;

import com.tingeso.LAB1.entities.DatosEntity;
import com.tingeso.LAB1.repositories.DatosRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class DatosService {

    @Autowired
    DatosRepository datosRepository;
    private String carpeta="archivos//";
    private final Logger log = LoggerFactory.getLogger(DatosService.class);

    public void guardar(MultipartFile archivo){
        if (!archivo.isEmpty()){
            try {
                byte [] arr = archivo.getBytes();
                Path ruta = Paths.get(carpeta+archivo.getOriginalFilename());
                Files.write(ruta,arr);
                log.info("Archivo subido");
                datosRepository.importarDatos(String.valueOf(ruta));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public List<Map<String,Object>> resultadoConsulta(){
        return datosRepository.reordenarDatos();
    }

}
