package com.test.expertis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.expertis.modelo.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long>{

	
}
