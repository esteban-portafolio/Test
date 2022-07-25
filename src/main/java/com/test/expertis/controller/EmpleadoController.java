package com.test.expertis.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import com.test.expertis.modelo.DTO.EmpleadoDto;
import com.test.expertis.service.EmpleadoService;


@RestController
public class EmpleadoController {
	
	private final EmpleadoService eService;
	
	@Autowired
    public EmpleadoController(EmpleadoService eService){
        this.eService=eService;
    }

    @PostMapping(value = "/crearEmpleado")
    public ResponseEntity<EmpleadoDto> addEmpleado(@RequestBody final EmpleadoDto empleadoDto){
        Empleado empleado =eService.addEmpleado(Empleado.toDomai(empleadoDto));
        return new ResponseEntity<>(EmpleadoDto.toDomain(empleado), HttpStatus.OK);
    }

    @GetMapping(value = "/empleados")
    public ResponseEntity<List<EmpleadoDto>> getEmpleados(){
        List<Empleado> empleados =eService.getEmpleados();
        List<EmpleadoDto> empleadoDtoList = empleados.stream().map(EmpleadoDto::toDomain).collect(Collectors.toList());
        return new ResponseEntity<>(empleadoDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/empleados/{id}")
    public ResponseEntity<EmpleadoDto> getEmpleado(@PathVariable final Long id){
        Empleado empleado =eService.getEmpleado(id);
        return new ResponseEntity<>(EmpleadoDto.toDomain(empleado),HttpStatus.OK);
    }

    @DeleteMapping(value = "/empleados/{id}")
    public ResponseEntity<EmpleadoDto> deleteEmpleado(@PathVariable final Long id){
        Empleado empleado =eService.deleteEmpleado(id);
        return new ResponseEntity<>(EmpleadoDto.toDomain(empleado),HttpStatus.OK);
    }

    @PutMapping(value = "/empleados/{id}")
    public ResponseEntity<EmpleadoDto> updateEmpleado(@PathVariable final Long id,
                                                      @RequestBody final EmpleadoDto empleadoDto){
        Empleado empleado = eService.updateEmpleado(id,Empleado.toDomai(empleadoDto));
        return new ResponseEntity<>(EmpleadoDto.toDomain(empleado),HttpStatus.OK);
    }
	 
}
