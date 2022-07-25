package com.test.expertis.repository;

import org.springframework.stereotype.Repository;

import com.test.expertis.modelo.Departamento;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

	
}
