package com.test.expertis.exception;

import java.text.MessageFormat;

public class EmpleadoIsAlreadyAssignedException  extends RuntimeException{

	public EmpleadoIsAlreadyAssignedException(final Long empleadoId, final Long departamentoId){
        super(MessageFormat.format("Empleado: {0} se encuentra asignado al Departamento: {1}", empleadoId, departamentoId));
    }
}
