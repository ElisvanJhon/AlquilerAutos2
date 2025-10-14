package avance1.com.Avance_1.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "Mantenimiento")
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_mantenimiento;
    private LocalDate fecha_mantenimiento;
    private String tipo;
    @Column(columnDefinition = "text")
    private String descripcion;
    private BigDecimal costo;
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    // Getters y setters
}