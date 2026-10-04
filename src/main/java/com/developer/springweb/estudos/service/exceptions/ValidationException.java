package com.developer.springweb.estudos.service.exceptions;

public class ValidationException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ValidationException(String msg) {
		super(msg);
	}
}
