package com.test.expertis.modelo.DTO;

import com.test.expertis.modelo.Departamento;

import lombok.Data;

@Data
public class UnionEmpleDept {

	private Long id;
    private String name;
    private boolean estado;
    
    public static UnionEmpleDept toDomain(Departamento departamento){
        UnionEmpleDept plainDepartamentoDto = new UnionEmpleDept();
        plainDepartamentoDto.setId(departamento.getId());
        plainDepartamentoDto.setName(departamento.getNom_dep());
        plainDepartamentoDto.setEstado(departamento.isEstado());
        return plainDepartamentoDto;
    }
}
