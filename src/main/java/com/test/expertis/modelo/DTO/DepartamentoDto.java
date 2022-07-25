package com.test.expertis.modelo.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.test.expertis.modelo.Departamento;

import lombok.Data;

@Data
public class DepartamentoDto {

	private Long id;
    private String name;
    private boolean estado;
    private List<EmpleadoDto> empleadoDtoList = new ArrayList<>();
    
    public static DepartamentoDto toDomain(Departamento departamento){
        DepartamentoDto departamentoDto = new DepartamentoDto();
        departamentoDto.setId(departamento.getId());
        departamentoDto.setName(departamento.getNom_dep());
        departamentoDto.setEstado(departamento.isEstado());
        if(Objects.nonNull(departamento.getEmpleadoList())){
            departamentoDto.setEmpleadoDtoList(departamento.getEmpleadoList().stream().map(EmpleadoDto::toDomain).collect(Collectors.toList()));
        }
        return departamentoDto;
    }
    
}
