package avance1.com.Avance_1.entities;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_empleado;
    private String nombre;
    private String apellido;
    private String cargo;
    private String telefono;
    private String email;
    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
    @OneToMany(mappedBy = "empleado")
    private List<Contrato> contratos;
    @OneToMany(mappedBy = "empleado")
    private List<Mantenimiento> mantenimientos;
    @OneToMany(mappedBy = "empleado")
    private List<Danio> danos;
    // Getters y setters
}