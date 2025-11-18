package com.alquiler.demo.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alquiler")
    private Integer idAlquiler;

    @Column(name = "fecha_inicio_real")
    private LocalDate fechaInicioReal;

    @Column(name = "fecha_fin_real")
    private LocalDate fechaFinReal;

    @Column(name = "kilometraje_inicio")
    private Integer kilometrajeInicio;

    @Column(name = "kilometraje_fin")
    private Integer kilometrajeFin;

    @Column(name = "costo_total")
    private BigDecimal costoTotal;

    @OneToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;

    @OneToMany(mappedBy = "alquiler")
    private List<Pago> pagos;

    @OneToMany(mappedBy = "alquiler")
    private List<Danio> danos;
}
