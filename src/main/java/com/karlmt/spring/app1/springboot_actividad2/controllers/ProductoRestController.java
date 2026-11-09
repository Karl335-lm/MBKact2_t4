package com.karlmt.spring.app1.springboot_actividad2.controllers;

import com.karlmt.spring.app1.springboot_actividad2.dto.ProductoDTO;
import com.karlmt.spring.app1.springboot_actividad2.service.ProductoService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    private final ProductoService productoService;

    public ProductoRestController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ProductoDTO recibirProducto(
            @RequestBody ProductoDTO producto) {

        productoService.guardar(producto);

        System.out.println(
                "Producto recibido: " + producto.getNombre()
        );

        return producto;
    }
}