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

import com.test.expertis.modelo.Departamento;
import com.test.expertis.modelo.DTO.DepartamentoDto;
import com.test.expertis.service.DepartamentoService;



@RestController
public class DepartamentoController {
	
	private final DepartamentoService dService;
	
	
	@Autowired
    public DepartamentoController(DepartamentoService dService){
        this.dService=dService;
    }

    @PostMapping(value="/createDepartamento")
    public ResponseEntity<DepartamentoDto> addDepartamento(@RequestBody final DepartamentoDto departamentoDto){
        Departamento departamento = dService.addDepartamento(Departamento.toDomain(departamentoDto));
        return new ResponseEntity<>(DepartamentoDto.toDomain(departamento), HttpStatus.OK);
    }

    @GetMapping(value="/departamentos")
    public ResponseEntity<List<DepartamentoDto>> getDepartamentos(){
        List<Departamento> departamentos = dService.getDepartamentos();
        List<DepartamentoDto> departamentosDto = departamentos.stream().map(DepartamentoDto::toDomain).collect(Collectors.toList());
        return new ResponseEntity<>(departamentosDto,HttpStatus.OK);
    }

    @GetMapping(value = "/departamentos/{id}")
    public ResponseEntity<DepartamentoDto> getDepartamento(@PathVariable final Long id){
        Departamento departamento =dService.getDepartamento(id);
        return new ResponseEntity<>(DepartamentoDto.toDomain(departamento), HttpStatus.OK);
    }
    @DeleteMapping(value = "/departamentos/{id}")
    public ResponseEntity<DepartamentoDto> deleteDepartamento(@PathVariable final Long id){
        Departamento departamento = dService.deleteDepartamento(id);
        return new ResponseEntity<>(DepartamentoDto.toDomain(departamento),HttpStatus.OK);
    }
    @PutMapping(value = "/departamentos/{id}")
    public ResponseEntity<DepartamentoDto> updateDepartamento(@PathVariable final Long id,@RequestBody final DepartamentoDto departamentoDto){
        Departamento departamento = dService.updateDepartamento(id,Departamento.toDomain(departamentoDto));
        return new ResponseEntity<>(DepartamentoDto.toDomain(departamento),HttpStatus.OK);

    }

    @PostMapping(value = "/departamentos/{departamentoId}/empleados/{empleadoId}/add")
    public ResponseEntity<DepartamentoDto> addEmpleadoToDepartamento(@PathVariable final Long departamentoId,@PathVariable final Long empleadoId ){
        Departamento departamento = dService.addEmpleadoToDepartamento(departamentoId,empleadoId);
        return new ResponseEntity<>(DepartamentoDto.toDomain(departamento),HttpStatus.OK);
    }

    @DeleteMapping(value ="/departamentos/{departamentoId}/empleados/{empleadoId}/remove" )
    public ResponseEntity<DepartamentoDto> removeEmpleadoToDepartamento(@PathVariable final Long departamentoId,@PathVariable final Long empleadoId ){
        Departamento departamento = dService.removeEmpleadofromDepartamento(departamentoId,empleadoId);
        return new ResponseEntity<>(DepartamentoDto.toDomain(departamento),HttpStatus.OK);
    }

}
