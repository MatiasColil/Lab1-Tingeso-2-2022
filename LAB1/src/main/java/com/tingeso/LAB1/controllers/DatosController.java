package com.tingeso.LAB1.controllers;

import com.tingeso.LAB1.entities.DatosEntity;
import com.tingeso.LAB1.entities.EntradasEntity;
import com.tingeso.LAB1.services.DatosService;
import com.tingeso.LAB1.services.EntradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.expression.Lists;

import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping
public class DatosController {

    @Autowired
    DatosService datosService;

    @Autowired
    EntradasService entradasService;

    @PostMapping("/cargar")
    public String subir(@RequestParam("archivos") MultipartFile file) throws IOException {
        datosService.guardar(file);
        List<Map<String,String>> jg = datosService.resultadoConsulta();
        entradasService.guardarTest(jg);
        return "redirect:/";
    }

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

}
