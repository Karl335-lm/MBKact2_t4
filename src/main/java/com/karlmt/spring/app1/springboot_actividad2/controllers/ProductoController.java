package com.karlmt.spring.app1.springboot_actividad2.controllers;

import com.karlmt.spring.app1.springboot_actividad2.dto.ProductoDTO;
import com.karlmt.spring.app1.springboot_actividad2.service.ProductoService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductoController {

    private final ProductoService productoService;

    @Value("${app.nombre}")
    private String nombreAplicacion;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public String listarProductos(Model model) {

        model.addAttribute("productos", productoService.listar());
        model.addAttribute("nombreAplicacion", nombreAplicacion);

        return "lista";
    }

    @GetMapping("/productos/filtrar")
    public String filtrarProductos(
            @RequestParam String categoria,
            Model model) {

        model.addAttribute(
                "productos",
                productoService.filtrarPorCategoria(categoria)
        );

        model.addAttribute("nombreAplicacion", nombreAplicacion);

        return "lista";
    }

    @GetMapping("/productos/detalle/{id}")
    public String detalleProducto(
            @PathVariable Long id,
            Model model) {

        ProductoDTO producto = productoService.buscarPorId(id);

        if (producto == null) {
            return "redirect:/productos";
        }

        model.addAttribute("producto", producto);
        model.addAttribute("nombreAplicacion", nombreAplicacion);

        return "detalle";
    }

    @GetMapping("/productos/formulario")
    public String mostrarFormulario(Model model) {

        model.addAttribute("producto", new ProductoDTO());
        model.addAttribute("nombreAplicacion", nombreAplicacion);

        return "formulario";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(
            @ModelAttribute ProductoDTO producto) {

        productoService.guardar(producto);

        return "redirect:/productos";
    }
}