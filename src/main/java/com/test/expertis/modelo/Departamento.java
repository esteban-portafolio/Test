package com.test.expertis.modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;

@Builder
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

	public Departamento() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom_dep() {
		return nom_dep;
	}

	public void setNom_dep(String nom_dep) {
		this.nom_dep = nom_dep;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public Departamento(long id, String nom_dep, boolean estado) {
		super();
		this.id = id;
		this.nom_dep = nom_dep;
		this.estado = estado;
	}



	
	
	

}
