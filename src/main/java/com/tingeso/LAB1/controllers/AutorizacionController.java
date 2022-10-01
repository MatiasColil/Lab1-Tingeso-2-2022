package com.tingeso.LAB1.controllers;

import com.tingeso.LAB1.services.AutorizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping
public class AutorizacionController {

    @Autowired
    AutorizacionService autorizacionService;

    @PostMapping(value = "/guardarautorizacion")
    public String guardarJUstificativo( @RequestBody MultiValueMap autorizacion){
        autorizacionService.guardarAutorizacion(autorizacion);
        return "redirect:/";
    }

    @GetMapping("/autorizacion")
    public String mostrarPagJustificativo(){
        return "autorizacion";
    }
}
