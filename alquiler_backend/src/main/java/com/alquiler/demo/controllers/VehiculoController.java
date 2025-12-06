package com.alquiler.demo.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alquiler.demo.entities.Vehiculo;
import com.alquiler.demo.services.VehiculoService;


@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "http://localhost:4200")
public class VehiculoController {
	
	private final VehiculoService vehiculoService;
	
	public VehiculoController(VehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}

	//@PostMapping
	//public Vehiculo save(@RequestBody Vehiculo vehiculo) {
		//return vehiculoService.save(vehiculo);
	//}
	
	@GetMapping
	public List<Vehiculo> findAll(){
		return vehiculoService.findAll();
	}

	@GetMapping("/marca/{marca}")
    public List<Vehiculo> buscarPorMarca(@PathVariable String marca) {
        return vehiculoService.buscarPorMarca(marca);
    }

    // 🔹 Buscar por año
    @GetMapping("/anio/{anio}")
    public List<Vehiculo> buscarPorAnio(@PathVariable Integer anio) {
        return vehiculoService.buscarPorAnio(anio);
    }
    
    @GetMapping("/tipo/{tipoVehiculo}")
    public List<Vehiculo> buscarPorTipoVehiculo(@PathVariable String tipoVehiculo) {
        return vehiculoService.buscarPorTipo(tipoVehiculo);
    }
    
    
}