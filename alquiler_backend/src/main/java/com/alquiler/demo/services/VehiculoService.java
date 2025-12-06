package com.alquiler.demo.services;

import com.alquiler.demo.entities.Vehiculo;
import java.util.List;
import java.util.Optional;

public interface VehiculoService {
	
    List<Vehiculo> findAll();
    Optional<Vehiculo> findById(Integer id);

    List<Vehiculo> buscarPorMarca(String marca);

    List<Vehiculo> buscarPorAnio(Integer anio);
    
    List<Vehiculo> buscarPorTipo(String tipoVehiculo);
}
