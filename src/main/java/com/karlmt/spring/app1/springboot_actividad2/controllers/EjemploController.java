package com.karlmt.spring.app1.springboot_actividad2.controllers;

import com.karlmt.spring.app1.springboot_actividad2.models.empleados;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class EjemploController {

    @GetMapping("/detalles_info2")
    public String detalles_info2(Model model) {
        empleados empleado1 = new empleados("Juan", "Martinez", "Calle 1", 35, 123456789L, 2);

        model.addAttribute("titulo", "Datos del Empleado");
        model.addAttribute("empleado", empleado1);

        // Retorna el nombre de la plantilla HTML en src/main/resources/templates/detalles_info2.html
        return "detalles_info2"; 
    }
}