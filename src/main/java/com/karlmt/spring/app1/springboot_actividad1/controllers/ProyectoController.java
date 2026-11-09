package com.karlmt.spring.app1.springboot_actividad1.controllers;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoController {

    @GetMapping("/api/proyecto")
    public Map<String, String> obtenerProyecto() {

        return Map.of(
            "proyecto", "Spring Boot Actividad 1",
            "autor", "Karla Martinez Bautista",
            "descripcion", "Proyecto de prueba con Spring Boot"
        );
    }
}