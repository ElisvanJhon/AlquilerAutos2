package com.alquiler.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehiculoController {

    @GetMapping("/vehiculo_listar")
    public String listarVehiculos() {
        return "admin/vehiculo_listar";
    }

    @GetMapping("/vehiculos_form")
    public String agregarVehiculo() {
        return "admin/vehiculo_form";
    }

    @GetMapping("/vehiculo_detalle")
    public String editarVehiculo() {
        return "admin/vehiculo_detalle";
    }

    @GetMapping("/vehiculos_mantenimiento")
    public String mantenimientoVehiculo() {
        return "admin/vehiculo_mantenimiento";
    }
}