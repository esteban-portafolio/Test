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
import com.test.expertis.modelo.DTO.EmpleadoDto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "empleados")
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
	
	@ManyToOne
	private Departamento departamento;
	
	
	public static Empleado toDomai(EmpleadoDto empleadoDto) {
		Empleado empleado = new Empleado();
		empleado.setNombre(empleadoDto.getNombre());
		empleado.setSalario(empleadoDto.getSalario());
		empleado.setEspecialidad(empleadoDto.getEspecialidad());
        empleado.setFecha(empleadoDto.getFecha());
        return empleado;
	}
	




	
	
	
	
	

}
