package avance1.com.Avance_1.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "Dano")
public class Danio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_dano;
    @Column(columnDefinition = "text")
    private String descripcion;
    private BigDecimal costo_estimado;
    private LocalDate fecha_registro;
    @ManyToOne
    @JoinColumn(name = "id_alquiler")
    private Alquiler alquiler;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    // Getters y setters
}