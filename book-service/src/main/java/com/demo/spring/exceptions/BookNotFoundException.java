package com.demo.spring.exceptions;

public class BookNotFoundException extends RuntimeException {
	public BookNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public BookNotFoundException(String message) {
		super(message);
	}
}
