package com.alquiler.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "Vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;

    private String placa;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private String estado;
    private Integer asientos;
    private double precioDiario;
    private String combustible;
    private String transmision;

    @Column(name = "tipo_vehiculo")
    private String tipoVehiculo;

    @Column(name = "kilometraje_actual")
    private Integer kilometrajeActual;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    @JsonBackReference
    private Sucursal sucursal;

    @OneToMany(mappedBy = "vehiculo")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "vehiculo")
    private List<Mantenimiento> mantenimientos;

    @OneToMany(mappedBy = "vehiculo")
    private List<Seguro> seguros;
    
    private String imagen;

    // Getters y setters
    
    
    public String getImagen() 
    { return imagen; }
    
    public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public String getTransmision() {
		return transmision;
	}

	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}

	public void setImagen(String imagen) 
    { this.imagen = imagen; }

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getAsientos() {
		return asientos;
	}

	public void setAsientos(Integer asientos) {
		this.asientos = asientos;
	}

	public double getPrecioDiario() {
		return precioDiario;
	}

	public void setPrecioDiario(double precioDiario) {
		this.precioDiario = precioDiario;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Integer getKilometrajeActual() {
		return kilometrajeActual;
	}

	public void setKilometrajeActual(Integer kilometrajeActual) {
		this.kilometrajeActual = kilometrajeActual;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}
    
    
}
