package avance1.com.Avance_1.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "Vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_vehiculo;
    private String placa;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private String estado;
    private Integer asientos;
    private String tipo_vehiculo;
    private Integer kilometraje_actual;
    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;
    @OneToMany(mappedBy = "vehiculo")
    private List<Reserva> reservas;
    @OneToMany(mappedBy = "vehiculo")
    private List<Mantenimiento> mantenimientos;
    @OneToMany(mappedBy = "vehiculo")
    private List<Seguro> seguros;
    // Getters y setters
}