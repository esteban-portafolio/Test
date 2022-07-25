package com.test.expertis.service;

import java.util.List;

import com.test.expertis.modelo.Departamento;

public interface IDepartamentoService {
	
	List<Departamento>listar();
	Departamento listDepartamentoID(long id);
	Departamento agregar(Departamento d);
	Departamento actualizar(Departamento d);
	void delete(long id);

}
