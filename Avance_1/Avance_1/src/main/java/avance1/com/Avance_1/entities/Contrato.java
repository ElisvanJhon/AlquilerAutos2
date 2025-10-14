package avance1.com.Avance_1.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_contrato;
    private LocalDate fecha_firma;
    @Column(columnDefinition = "text")
    private String terminos_condiciones;
    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    @OneToOne(mappedBy = "contrato")
    private Alquiler alquiler;
    // Getters y setters
}