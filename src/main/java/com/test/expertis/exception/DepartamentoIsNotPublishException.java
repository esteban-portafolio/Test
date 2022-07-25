package com.test.expertis.exception;

import java.text.MessageFormat;

public class DepartamentoIsNotPublishException extends RuntimeException{

	 public DepartamentoIsNotPublishException(final Long departamentoId){
	        super(MessageFormat.format("no se puede asignar El Departamento: {1} , no se encuentra activo", departamentoId));
	 }
}
