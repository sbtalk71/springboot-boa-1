package com.demo.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.Builder;

import com.demo.spring.dto.BookDTO;

@RestController
@RequestMapping("/library")
public class LibraryController {

	private RestClient.Builder restClientBuilder;
	
	public LibraryController(Builder restClientBuilder) {
		
		this.restClientBuilder = restClientBuilder;
	}


	@GetMapping(path="/books/{id}")
	public ResponseEntity<BookDTO> locateBook(@PathVariable String id){
		BookDTO dto= restClientBuilder.build()
				.get()
				.uri("http://localhost:8181/books/"+id)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(BookDTO.class);
		
		return ResponseEntity.ok(dto);
	}
}
