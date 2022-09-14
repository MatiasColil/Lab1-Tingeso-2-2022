package com.tingeso.LAB1.controllers;

import com.tingeso.LAB1.entities.DatosEntity;
import com.tingeso.LAB1.entities.EntradasEntity;
import com.tingeso.LAB1.services.EntradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class EntradasController {

    @Autowired
    EntradasService entradasService;

    /*
    @GetMapping("/test")
    public String abcde(Model model){
        List<EntradasEntity> jg = entradasService.resultadoConsulta();
        model.addAttribute("jg",jg);
        //entradasService.guardarDatos((EntradasEntity) jg);
        return "pruebas";
    }

     */
}
