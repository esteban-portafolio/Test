package com.test.expertis.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.expertis.exception.ResourceNotFoundException;
import com.test.expertis.modelo.Empleado;
import com.test.expertis.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService{
	
	@Autowired
	private EmpleadoRepository eRepository;

	@Override
	public List<Empleado> listar() {

		return this.eRepository.findAll();
	}

	@Override
	public Empleado listEmpleadoID(long id) {
		Optional<Empleado> eOptional = this.eRepository.findById(id);
		
		if (eOptional.isPresent()) {
			return eOptional.get();
		}else {
			throw new ResourceNotFoundException("No existe data con el ID: "+ id);
		}
		
	}

	@Override
	public Empleado crear(Empleado empleado) {
		
		return eRepository.save(empleado);
	}

	@Override
	public Empleado actualizar(Empleado empleado) {
		Optional<Empleado> eOptional = this.eRepository.findById(empleado.getId());
		
		if (eOptional.isPresent()) {
			Empleado eUpdate = eOptional.get();
			eUpdate.setId(empleado.getId());
			eUpdate.setEspecialidad(empleado.getEspecialidad());
			eUpdate.setNombre(empleado.getNombre());
			eUpdate.setSalario(empleado.getSalario());
			eUpdate.setFecha(empleado.getFecha());
			eRepository.save(eUpdate);
			
			return eUpdate;
		}else {
			throw new ResourceNotFoundException("No existe data con el ID: "+ empleado.getId());
		}
		
	}

	@Override
	public void delete(long id) {
		Optional<Empleado> eOptional = this.eRepository.findById(id);
		
		if (eOptional.isPresent()) {
			this.eRepository.delete(eOptional.get());
		}else {
			throw new ResourceNotFoundException("No existe data con el ID: "+ id);
		}
		
	}

	


	

}
