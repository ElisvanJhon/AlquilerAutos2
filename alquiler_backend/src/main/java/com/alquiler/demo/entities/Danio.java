package com.alquiler.demo.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Dano")
public class Danio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dano")
    private Integer idDano;

    @Column(columnDefinition = "text")
    private String descripcion;

    @Column(name = "costo_estimado")
    private BigDecimal costoEstimado;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_alquiler")
    private Alquiler alquiler;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
}
