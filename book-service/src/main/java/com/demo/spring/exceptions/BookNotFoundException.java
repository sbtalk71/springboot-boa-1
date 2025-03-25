package com.demo.spring.exceptions;

public class BookNotFoundException extends BookResourceException {
	public BookNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public BookNotFoundException(String message) {
		super(message);
	}
}
