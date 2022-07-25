package com.test.expertis.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.expertis.exception.DepartamentoIsNotPublishException;
import com.test.expertis.exception.EmpleadoIsAlreadyAssignedException;
import com.test.expertis.exception.ResourceNotFoundException;
import com.test.expertis.modelo.Departamento;
import com.test.expertis.modelo.Empleado;
import com.test.expertis.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

	private final DepartamentoRepository dRepository;
	private final EmpleadoService eService;

	@Autowired
	public DepartamentoService(DepartamentoRepository dRepository, EmpleadoService eService) {
		this.dRepository = dRepository;
		this.eService = eService;
	}

	public Departamento addDepartamento(Departamento departamento) {
		return dRepository.save(departamento);
	}

	public List<Departamento> getDepartamentos() {
		return StreamSupport.stream(dRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	public Departamento getDepartamento(Long id) {
		return dRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Departamento deleteDepartamento(Long id) {
		Departamento departamento = getDepartamento(id);
		dRepository.delete(departamento);
		return departamento;
	}

	@Transactional
	public Departamento updateDepartamento(Long id, Departamento departamento) {
		Departamento departamentoUpdate = getDepartamento(id);
		departamentoUpdate.setNom_dep(departamento.getNom_dep());
		departamentoUpdate.setEstado(departamento.isEstado());
		return departamentoUpdate;
	}

	@Transactional
    public Departamento addEmpleadoToDepartamento(Long departamentoId,Long empleadoId){
        Departamento departamento = getDepartamento(departamentoId);
        Empleado empleado = eService.getEmpleado(empleadoId);
        if(Objects.nonNull(empleado.getDepartamento())){
            throw new EmpleadoIsAlreadyAssignedException(empleadoId,empleado.getDepartamento().getId());
        }if(!departamento.isEstado()) {
            throw new DepartamentoIsNotPublishException(departamentoId);
        }
        departamento.addEmpleado(empleado);
        empleado.setDepartamento(departamento);
        return departamento;
    }

	@Transactional
	public Departamento removeEmpleadofromDepartamento(Long departamentoId, Long empleadoId) {
		Departamento departamento = getDepartamento(departamentoId);
		Empleado empleado = eService.getEmpleado(empleadoId);
		departamento.removeEmpleado(empleado);
		empleado.setDepartamento(null);
		eService.updateEmpleado(empleadoId, empleado);
		return departamento;
	}

}
