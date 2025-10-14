package avance1.com.Avance_1.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "Seguro")
public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_seguro;
    private String compania;
    private String tipo_cobertura;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private BigDecimal costo;
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;
    // Getters y setters
}
