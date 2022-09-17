package com.tingeso.LAB1.controllers;

import com.tingeso.LAB1.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ReporteController {

    @Autowired
    ReporteService reporteService;
}
