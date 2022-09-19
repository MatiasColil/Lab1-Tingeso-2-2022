package com.tingeso.LAB1.controllers;

import com.tingeso.LAB1.entities.AutorizacionEntity;
import com.tingeso.LAB1.services.AutorizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import org.w3c.dom.Element;
import org.w3c.dom.html.HTMLElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
