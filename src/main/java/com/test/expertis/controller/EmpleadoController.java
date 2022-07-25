package com.test.expertis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.expertis.modelo.Empleado;
import com.test.expertis.service.IEmpleadoService;

@RestController
public class EmpleadoController {
	
	@Autowired
	private IEmpleadoService eservice;
	
	@GetMapping("/empleados")
	public ResponseEntity<List<Empleado>> getAll() {
		List<Empleado> lista = eservice.listar();
		return new ResponseEntity<List<Empleado>>(lista, HttpStatus.OK);
		
	}
	
	@GetMapping("/empleado/{id}")
	public ResponseEntity<Empleado> getEmpleadoById(@PathVariable long id){
		return ResponseEntity.ok().body(eservice.listEmpleadoID(id));
				
	}
	
	@PostMapping("/crear")
	public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado){
		return ResponseEntity.ok().body(this.eservice.crear(empleado));
	}
	
	@PutMapping("/empleado/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable long id, @RequestBody Empleado empleado){
		empleado.setId(id);
		return ResponseEntity.ok().body(this.eservice.actualizar(empleado));
	}
	
	@DeleteMapping("/empleado/{id}")
	public ResponseEntity<Object> eliminarEmpleado(@PathVariable long id){
		eservice.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	
	}
	 
}
