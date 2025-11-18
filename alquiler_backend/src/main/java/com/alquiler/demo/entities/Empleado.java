package com.alquiler.demo.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    private String nombre;
    private String apellido;
    private String cargo;
    private String telefono;
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    @OneToMany(mappedBy = "empleado")
    private List<Contrato> contratos;

    @OneToMany(mappedBy = "empleado")
    private List<Mantenimiento> mantenimientos;

    @OneToMany(mappedBy = "empleado")
    private List<Danio> danos;
}
