package com.pet.exception;

public class InvalidBinaryException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InvalidBinaryException(String message) {
		super(message);
	}

}