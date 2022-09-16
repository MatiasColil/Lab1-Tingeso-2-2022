package com.tingeso.LAB1.controllers;

import com.tingeso.LAB1.entities.JustificativoEntity;
import com.tingeso.LAB1.services.JustificativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class JustificativoController {

    @Autowired
    JustificativoService justificativoService;

    @PostMapping("/guardarjustificativo")
    public String guardarJUstificativo(JustificativoEntity justificativoObject){
        justificativoService.guardarJustificativo(justificativoObject);
        return "home";
    }

    @GetMapping("/justificativo")
    public String mostrarPagJustificativo(){
        return "justificativo";
    }
}
