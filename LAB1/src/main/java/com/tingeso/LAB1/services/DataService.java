package com.tingeso.LAB1.services;

import org.apache.tomcat.jni.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DataService {

    private String carpeta="archivos//";
    private final Logger log = LoggerFactory.getLogger(DataService.class);

    public String guardar(MultipartFile archivo){
        if (!archivo.isEmpty()){
            try {
                byte [] arr = archivo.getBytes();
                Path ruta = Paths.get(carpeta+archivo.getOriginalFilename());
                Files.write(ruta,arr);
                log.info("Archivo subido");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "Archivo guardado";
    }
}
