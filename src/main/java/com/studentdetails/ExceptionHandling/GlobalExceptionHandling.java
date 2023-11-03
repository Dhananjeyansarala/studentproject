package com.studentdetails.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.studentdetails.customException.AgeException;

@RestControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler(AgeException.class)
	public ResponseEntity<Object> ageException() {
		return new ResponseEntity<Object>("Age is less than 18", HttpStatus.BAD_REQUEST);
	}

}
