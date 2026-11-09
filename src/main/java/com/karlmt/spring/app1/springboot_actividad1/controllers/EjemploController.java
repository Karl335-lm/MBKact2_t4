package com.karlmt.spring.app1.springboot_actividad1.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ejemplo")
public class EjemploController {

    @GetMapping("/detalles_info")
    public Map<String, Object> info() {
        Map<String, Object> model = new HashMap<>();
        model.put("Titulo", "Servidor en linea");
        model.put("Servidor", "Informaticonfig");
        model.put("Ip", "192.168.0.19");
        return model;
    }
}