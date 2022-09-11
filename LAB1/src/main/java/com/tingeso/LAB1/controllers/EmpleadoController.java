package com.tingeso.LAB1.controllers;

import com.tingeso.LAB1.entities.EmpleadoEntity;
import com.tingeso.LAB1.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/plantilla")
    public String empleados(Model model){
        ArrayList <EmpleadoEntity> empleados=empleadoService.obtenerEmpleados();
        model.addAttribute("empleados", empleados);
        return "plantilla";
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
