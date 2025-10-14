package avance1.com.Avance_1.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "Alquiler")
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alquiler;
    private LocalDate fecha_inicio_real;
    private LocalDate fecha_fin_real;
    private Integer kilometraje_inicio;
    private Integer kilometraje_fin;
    private BigDecimal costo_total;
    @OneToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;
    @OneToMany(mappedBy = "alquiler")
    private java.util.List<Pago> pagos;
    @OneToMany(mappedBy = "alquiler")
    private java.util.List<Danio> danos;
    // Getters y setters
}