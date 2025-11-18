package com.alquiler.demo.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Integer idSucursal;

    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;

    @OneToMany(mappedBy = "sucursal")
    private List<Empleado> empleados;

    @OneToMany(mappedBy = "sucursal")
    private List<Vehiculo> vehiculos;
}
