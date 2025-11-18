package com.alquiler.demo.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;

    private String placa;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private String estado;
    private Integer asientos;

    @Column(name = "tipo_vehiculo")
    private String tipoVehiculo;

    @Column(name = "kilometraje_actual")
    private Integer kilometrajeActual;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    @OneToMany(mappedBy = "vehiculo")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "vehiculo")
    private List<Mantenimiento> mantenimientos;

    @OneToMany(mappedBy = "vehiculo")
    private List<Seguro> seguros;
}
