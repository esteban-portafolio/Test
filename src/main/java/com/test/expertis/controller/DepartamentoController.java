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

import com.test.expertis.modelo.Departamento;

import com.test.expertis.service.IDepartamentoService;


@RestController
public class DepartamentoController {
	
	@Autowired
	private IDepartamentoService dService;
	
	
	@GetMapping("/departamentos")
	public ResponseEntity<List<Departamento>> getAll(){
		List<Departamento> dList = dService.listar();
		return new ResponseEntity<List<Departamento>>(dList, HttpStatus.OK);
	}
	
	@GetMapping("/departamento/{id}")
	public ResponseEntity<Departamento> getDepartmentById(@PathVariable long id){
		return ResponseEntity.ok().body(dService.listDepartamentoID(id));
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<Departamento> newDepartment(@RequestBody Departamento departamento){		
		return ResponseEntity.ok().body(this.dService.agregar(departamento));
	}
	
	@PutMapping("/departamento/{id}")
	public ResponseEntity<Departamento> updateDepartment(@PathVariable long id,@RequestBody Departamento departamento){
		departamento.setId(id);
		return ResponseEntity.ok().body(this.dService.actualizar(departamento));
	}
	
	@DeleteMapping("/departamento/{id}")
	public ResponseEntity<Object> deleteDepartament(@PathVariable long id){
		dService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}

}
