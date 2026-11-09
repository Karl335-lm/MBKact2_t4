package com.karlmt.spring.app1.springboot_actividad2.service;

import com.karlmt.spring.app1.springboot_actividad2.dto.ProductoDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    private final List<ProductoDTO> productos = new ArrayList<>();

    public ProductoService() {

        productos.add(new ProductoDTO(1L, "Laptop", 12500, "Electronica"));
        productos.add(new ProductoDTO(2L, "Mouse", 250, "Electronica"));
        productos.add(new ProductoDTO(3L, "Escritorio", 3500, "Muebles"));
        productos.add(new ProductoDTO(4L, "Silla", 1800, "Muebles"));
    }

    public List<ProductoDTO> listar() {
        return productos;
    }

    public void guardar(ProductoDTO producto) {

        if (producto.getId() == null) {
            Long nuevoId = productos.stream()
                    .mapToLong(ProductoDTO::getId)
                    .max()
                    .orElse(0) + 1;

            producto.setId(nuevoId);
        }

        productos.add(producto);
    }

    public ProductoDTO buscarPorId(Long id) {

        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<ProductoDTO> filtrarPorCategoria(String categoria) {

        List<ProductoDTO> resultado = new ArrayList<>();

        for (ProductoDTO producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(producto);
            }
        }

        return resultado;
    }
}
