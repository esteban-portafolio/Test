package com.test.expertis.modelo.DTO;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.expertis.modelo.Empleado;

import lombok.Data;

@Data
public class EmpleadoDto {
	
	private Long id;
	private String nombre;
	private double salario;
	private String especialidad;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate fecha;
	
	private UnionEmpleDept plainDepartamentoDto;
	
	public static EmpleadoDto toDomain(Empleado empleado){
        EmpleadoDto empleadoDto = new EmpleadoDto();
        empleadoDto.setId(empleado.getId());
        empleadoDto.setNombre(empleado.getNombre());
        empleadoDto.setSalario(empleado.getSalario());
        empleadoDto.setEspecialidad(empleado.getEspecialidad());
        empleadoDto.setFecha(empleado.getFecha());
        if(Objects.nonNull(empleado.getDepartamento())){
            empleadoDto.setPlainDepartamentoDto(UnionEmpleDept.toDomain(empleado.getDepartamento()));
        }
        return empleadoDto;
    }

}
