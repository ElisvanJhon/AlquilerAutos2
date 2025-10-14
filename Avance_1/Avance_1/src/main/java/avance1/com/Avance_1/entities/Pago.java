package avance1.com.Avance_1.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "Pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pago;
    private LocalDate fecha_pago;
    private BigDecimal monto;
    private String metodo_pago;
    private String tipo_comprobante;
    @ManyToOne
    @JoinColumn(name = "id_alquiler")
    private Alquiler alquiler;
    // Getters y setters
}
