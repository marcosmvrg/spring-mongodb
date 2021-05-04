package com.curso.mongodb.services.exception;

public class ObjectNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	
	public ObjectNotFoundException() {
		super();
	}
	
	public ObjectNotFoundException(String message) {
		super(message);
	}

}
