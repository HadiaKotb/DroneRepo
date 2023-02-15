package com.drones.drone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
public class InvalidRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidRequestException(String message) {
		super(message);
	}

}
