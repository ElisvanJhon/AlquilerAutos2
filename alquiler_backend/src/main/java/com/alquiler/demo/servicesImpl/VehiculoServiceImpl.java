package com.alquiler.demo.servicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alquiler.demo.entities.Vehiculo;
import com.alquiler.demo.repositories.VehiculoRepository;
import com.alquiler.demo.services.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService {

	private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }


	@Override
	public List<Vehiculo> buscarPorMarca(String marca) {
		
		return vehiculoRepository.findByMarcaIgnoreCase(marca);
	}

	@Override
	public List<Vehiculo> buscarPorAnio(Integer anio) {
		
		return vehiculoRepository.findByAnio(anio);
	}

	@Override
	public List<Vehiculo> buscarPorTipo(String tipoVehiculo) {

		return vehiculoRepository.findByTipoVehiculo(tipoVehiculo);
	}

	 @Override
	    public Vehiculo obtenerPorId(Integer id) {
	        return vehiculoRepository.findById(id).orElse(null);
	    }
	
	
}
