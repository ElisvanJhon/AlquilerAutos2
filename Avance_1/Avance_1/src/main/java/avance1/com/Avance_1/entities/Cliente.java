package avance1.com.Avance_1.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String direccion;
    private String email;
    private String licencia_conducir;
    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;
    // Getters y setters
}