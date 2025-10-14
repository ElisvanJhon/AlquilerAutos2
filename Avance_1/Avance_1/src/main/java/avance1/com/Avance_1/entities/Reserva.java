package avance1.com.Avance_1.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "Reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserva;
    private LocalDate fecha_reserva;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;
    @OneToOne(mappedBy = "reserva")
    private Contrato contrato;
    // Getters y setters
}