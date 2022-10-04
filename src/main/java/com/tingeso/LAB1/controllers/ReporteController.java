package com.tingeso.LAB1.controllers;

import com.tingeso.LAB1.entities.ReporteEntity;
import com.tingeso.LAB1.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping
public class ReporteController {

    @Autowired
    ReporteService reporteService;
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    EntradasService entradasService;
    @Autowired
    JustificativoService justificativoService;
    @Autowired
    AutorizacionService autorizacionService;

    @GetMapping("/generar")
    public String generarReporte(){
        reporteService.iteracion(empleadoService.obtenerEmpleados(),entradasService.obtenerEntradas(),justificativoService.obtenerJustificativos(),autorizacionService.obtenerAutorizaciones());
        return "redirect:/";
    }

    @GetMapping("/plantilla")
    public String mostrarReporte(Model model){
        List<ReporteEntity> reportes = reporteService.obtenerReportes();
        model.addAttribute("reportes", reportes);
        return "plantilla";
    }

}
