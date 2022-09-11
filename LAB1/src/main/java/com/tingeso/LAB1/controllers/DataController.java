package com.tingeso.LAB1.controllers;

import com.tingeso.LAB1.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping
public class DataController {

    @Autowired
    DataService dataService;

    @PostMapping("/cargar")
    public String subir(@RequestParam("archivos") MultipartFile file){
        dataService.guardar(file);
        return "redirect:/";
    }

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }
}
