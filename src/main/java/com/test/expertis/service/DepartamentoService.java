package com.test.expertis.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.expertis.exception.ResourceNotFoundException;
import com.test.expertis.modelo.Departamento;
import com.test.expertis.modelo.Empleado;
import com.test.expertis.repository.DepartamentoRepository;

@Service
public class DepartamentoService implements IDepartamentoService {

	@Autowired
	private DepartamentoRepository dRepository;

	@Override
	public List<Departamento> listar() {

		return this.dRepository.findAll();
	}

	@Override
	public Departamento listDepartamentoID(long id) {
		Optional<Departamento> dOptional = this.dRepository.findById(id);

		if (dOptional.isPresent()) {
			return dOptional.get();
		} else {
			throw new ResourceNotFoundException("No existe data con el ID: " + id);
		}
	}

	@Override
	public Departamento agregar(Departamento depart) {

		return dRepository.save(depart);
	}

	@Override
	public Departamento actualizar(Departamento depart) {
		Optional<Departamento> dOptional = this.dRepository.findById(depart.getId());

		if (dOptional.isPresent()) {
			Departamento dUpdate = dOptional.get();
			dUpdate.setId(depart.getId());
			dUpdate.setNom_dep(depart.getNom_dep());
			dUpdate.setEstado(depart.isEstado());
			dRepository.save(dUpdate);

			return dUpdate;
		} else {
			throw new ResourceNotFoundException("No existe data con el ID: " + depart.getId());
		}

	}

	@Override
	public void delete(long id) {
		Optional<Departamento> dOptional = this.dRepository.findById(id);

		if (dOptional.isPresent()) {
			this.dRepository.delete(dOptional.get());
		} else {
			throw new ResourceNotFoundException("No existe data con el ID: " + id);
		}

	}

}
