package com.test.expertis.exception;

import java.text.MessageFormat;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(final Long id) {
		super(MessageFormat.format("no se encontro el id: {0}",id));
	}
        
    
}
