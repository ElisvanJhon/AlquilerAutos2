package com.alquiler.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alquiler.demo.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // 🔹 Buscar cliente por DNI (único normalmente)
    Optional<Cliente> findByDni(String dni);

    // 🔹 Buscar cliente por correo electrónico
    Optional<Cliente> findByEmail(String email);

    // 🔹 Buscar clientes por nombre o apellido que contengan una cadena
    List<Cliente> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    // 🔹 Buscar por teléfono exacto
    Optional<Cliente> findByTelefono(String telefono);
}