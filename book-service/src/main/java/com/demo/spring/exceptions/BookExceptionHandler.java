package com.demo.spring.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.spring.util.ResponseMessage;

@RestControllerAdvice
public class BookExceptionHandler {

	@ExceptionHandler(BookResourceException.class)
	public ResponseEntity<ResponseMessage> handle(BookResourceException e){
		return ResponseEntity.status(404).body(new ResponseMessage(e.getMessage()));
	}
	
	
}
