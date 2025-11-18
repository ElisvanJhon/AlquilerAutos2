package com.alquiler.demo.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alquiler.demo.entities.Vehiculo;
import com.alquiler.demo.repositories.VehiculoRepository;
import com.alquiler.demo.services.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Optional<Vehiculo> findById(Integer id) {
        return vehiculoRepository.findById(id);
    }

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public Vehiculo update(Integer id, Vehiculo vehiculo) {
        if (vehiculoRepository.existsById(id)) {
            vehiculo.setIdVehiculo(id);
            return vehiculoRepository.save(vehiculo);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        vehiculoRepository.deleteById(id);
    }
}
