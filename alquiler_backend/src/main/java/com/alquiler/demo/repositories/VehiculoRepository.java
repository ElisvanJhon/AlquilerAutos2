package com.alquiler.demo.repositories;

import com.alquiler.demo.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    // 🔹 Buscar por placa exacta
    Vehiculo findByPlaca(String placa);

    // 🔹 Buscar por marca (ej: "Toyota", "Hyundai")
    List<Vehiculo> findByMarcaIgnoreCase(String marca);

    // 🔹 Buscar por modelo
    List<Vehiculo> findByModeloContainingIgnoreCase(String modelo);

    // 🔹 Buscar por tipo de vehículo (ej: "SUV", "Sedán", "Camioneta")
    List<Vehiculo> findByTipoVehiculoIgnoreCase(String tipoVehiculo);

    // 🔹 Buscar por estado (ej: "Disponible", "Mantenimiento", "Alquilado")
    List<Vehiculo> findByEstadoIgnoreCase(String estado);

    // 🔹 Buscar vehículos de una sucursal específica
    List<Vehiculo> findBySucursal_IdSucursal(Integer idSucursal);

    // 🔹 Buscar vehículos por rango de año
    List<Vehiculo> findByAnioBetween(Integer anioInicio, Integer anioFin);

    // 🔹 Buscar vehículos con kilometraje menor o igual a un valor
    List<Vehiculo> findByKilometrajeActualLessThanEqual(Integer kilometraje);

    // 🔹 Buscar vehículos con número específico de asientos
    List<Vehiculo> findByAsientos(Integer asientos);
}

