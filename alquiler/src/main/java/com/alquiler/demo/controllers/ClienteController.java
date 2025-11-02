package com.alquiler.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @GetMapping("/catalogo")
    public String mostrarCatalogo() {
        return "cliente/catalogo";
    }

    @GetMapping("/mis_reservas")
    public String mostrarReservasCliente() {
        return "cliente/mis_reservas";
    }

    @GetMapping("/perfil")
    public String mostrarPerfilCliente() {
        return "cliente/perfil";
    }

    @GetMapping("/mis_pagos")
    public String mostrarPagosCliente() {
        return "cliente/mis_pagos";
    }
    
    @GetMapping("/reserva_form")
    public String mostrarFormReserva() {
        return "cliente/reserva_form";
    }
}