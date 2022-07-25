package com.test.expertis.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;

@Builder
@Entity
@Table(name = "Empleados")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "salario")
	private double salario;
	
	@Column(name = "especialidad")
	private String especialidad;
	
	@Column(name = "fecha_ingreso")
	@JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate fecha;

	public Empleado() {
		
	}
	
	public Empleado(long id, String nombre, double salario, String especialidad, LocalDate fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.salario = salario;
		this.especialidad = especialidad;
		this.fecha = fecha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	
	
	
	
	

}
