package com.demo.spring.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LibraryExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handle(RuntimeException ex){
		return ResponseEntity.ok(ex.getMessage());
	}
}
