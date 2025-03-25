package com.demo.spring.dao;

public class BookNotFoundException extends RuntimeException {
	public BookNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public BookNotFoundException(String message) {
		super(message);
	}
}
