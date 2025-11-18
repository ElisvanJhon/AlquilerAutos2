package com.alquiler.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato")
    private Integer idContrato;

    @Column(name = "fecha_firma")
    private LocalDate fechaFirma;

    @Column(name = "terminos_condiciones", columnDefinition = "text")
    private String terminosCondiciones;

    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @OneToOne(mappedBy = "contrato")
    private Alquiler alquiler;
}
