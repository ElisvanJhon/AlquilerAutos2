package com.alquiler.demo.services;

import com.alquiler.demo.entities.Vehiculo;
import java.util.List;
import java.util.Optional;

public interface VehiculoService {
    List<Vehiculo> findAll();
    Optional<Vehiculo> findById(Integer id);
    Vehiculo save(Vehiculo vehiculo);
    Vehiculo update(Integer id, Vehiculo vehiculo);
    void delete(Integer id);
}
