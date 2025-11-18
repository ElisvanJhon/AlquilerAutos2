package com.alquiler.demo.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alquiler.demo.entities.Reserva;
import com.alquiler.demo.repositories.ReservaRepository;
import com.alquiler.demo.services.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> findById(Integer id) {
        return reservaRepository.findById(id);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva update(Integer id, Reserva reserva) {
        if (reservaRepository.existsById(id)) {
            reserva.setIdReserva(id);
            return reservaRepository.save(reserva);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        reservaRepository.deleteById(id);
    }
}
