package com.tingeso.LAB1.controllers;

import com.tingeso.LAB1.entities.AutorizacionEntity;
import com.tingeso.LAB1.entities.JustificativoEntity;
import com.tingeso.LAB1.services.AutorizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AutorizacionController {

    @Autowired
    AutorizacionService autorizacionService;

    @PostMapping("/guardarautorizacion")
    public String guardarJUstificativo(AutorizacionEntity autorizacionObject){
        autorizacionService.guardarAutorizacion(autorizacionObject);
        return "home";
    }

    @GetMapping("/autorizacion")
    public String mostrarPagJustificativo(){
        return "autorizacion";
    }
}
