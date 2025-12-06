package com.alquiler.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alquiler.demo.entities.Reserva;
import com.alquiler.demo.services.ReservaService;

@RestController
@RequestMapping("/api/reserva")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaController {
	
	private final ReservaService reservaService;
	
	
	public ReservaController(ReservaService reservaService) {
		this.reservaService = reservaService;
	}


	@PostMapping
		public Reserva save(@RequestBody Reserva reserva) {
			return reservaService.save(reserva);
		}

}
