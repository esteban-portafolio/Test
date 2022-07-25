package com.test.expertis.modelo;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.test.expertis.modelo.DTO.DepartamentoDto;


import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "Departamentos")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nombre_departamento")
	private String nom_dep;
	
	@Column(name = "activo")
	private boolean estado;

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "empleado_id")
    @ToString.Exclude
    private List<Empleado> empleadoList;
	
	public void addEmpleado(Empleado empleado){
        empleadoList.add(empleado);
    }
    public void removeEmpleado(Empleado empleado){
        empleadoList.remove(empleado);
    }

    public static Departamento toDomain(DepartamentoDto departamentoDto){
        Departamento departamento = new Departamento();
        departamento.setNom_dep(departamentoDto.getName());
        departamento.setEstado(departamentoDto.isEstado());
        return departamento;
    }


	
	
	

}
