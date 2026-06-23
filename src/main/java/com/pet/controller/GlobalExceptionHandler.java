package com.pet.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pet.exception.InvalidBinaryException;
import com.pet.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidBinaryException.class)
	public ResponseEntity<ErrorResponse> handleInvalidBinaryException (InvalidBinaryException ex){
		ErrorResponse error = new ErrorResponse(
				ex.getMessage(),
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value()
		);
		
		return ResponseEntity.badRequest().body(error);
	}
}
