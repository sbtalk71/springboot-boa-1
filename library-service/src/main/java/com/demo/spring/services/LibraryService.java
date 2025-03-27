package com.demo.spring.services;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.Builder;

import com.demo.spring.dto.BookDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class LibraryService {

private RestClient.Builder restClientBuilder;
	
	public LibraryService(Builder restClientBuilder) {
		
		this.restClientBuilder = restClientBuilder;
	}

	@CircuitBreaker(name="backendB",fallbackMethod = "fallbackGetBook")
	public BookDTO getBook(String isbn) {
		BookDTO dto= restClientBuilder.build()
				.get()
				.uri("http://book-service/books/"+isbn)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(BookDTO.class);
		return dto;
	}
	
	public BookDTO fallbackGetBook(Exception ex) {
		throw new RuntimeException("Service Unavailable");
	}
}
