package com.alquiler.demo.services;

import com.alquiler.demo.entities.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> findAll();
    Optional<Cliente> findById(Integer id);
    Cliente save(Cliente cliente);
    Cliente update(Integer id, Cliente cliente);
    void delete(Integer id);
}
