package com.karlmt.spring.app1.springboot_actividad1.controllers;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MateriasController {

    @GetMapping("/api/materias")
    public List<Map<String, Object>> obtenerMaterias() {

        return List.of(
            Map.of(
                "id", 1,
                "nombre", "Programacion",
                "creditos", 5
            ),
            Map.of(
                "id", 2,
                "nombre", "Bases de Datos",
                "creditos", 4
            ),
            Map.of(
                "id", 3,
                "nombre", "Redes",
                "creditos", 4
            )
        );
    }

    @GetMapping("/api/materias/total")
    public Map<String, Integer> obtenerTotalMaterias() {

        return Map.of("total", 3);
    }
}