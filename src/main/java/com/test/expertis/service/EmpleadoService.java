package com.test.expertis.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.expertis.exception.ResourceNotFoundException;
import com.test.expertis.modelo.Empleado;
import com.test.expertis.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
	
	
	private final EmpleadoRepository eRepository;

	@Autowired
    public EmpleadoService(EmpleadoRepository eRepository){
        this.eRepository = eRepository;
    }
    public Empleado addEmpleado(Empleado empleado){
        return  eRepository.save(empleado);
    }

    public List<Empleado> getEmpleados(){
        return StreamSupport
                .stream(eRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Empleado getEmpleado(Long id){
        return eRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }
    public Empleado deleteEmpleado(Long id){
        Empleado empleado = getEmpleado(id);
        eRepository.delete(empleado);
        return empleado;
    }

    @Transactional
    public Empleado updateEmpleado(Long id,Empleado empleado){
        Empleado empleadoUpdate = getEmpleado(id);
        empleadoUpdate.setNombre(empleado.getNombre());
        empleadoUpdate.setEspecialidad(empleado.getEspecialidad());
        empleadoUpdate.setSalario(empleado.getSalario());
        return empleadoUpdate;
    }

	


	

}
