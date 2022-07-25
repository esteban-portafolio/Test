package com.test.expertis.service;

import java.util.List;

import com.test.expertis.modelo.Empleado;

public interface IEmpleadoService {

	List<Empleado>listar();
	Empleado listEmpleadoID(long id);
	Empleado crear(Empleado empleado);
	Empleado actualizar(Empleado empleado);
	void delete(long id);
	
}
