package com.demo.spring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.dto.BookDTO;
import com.demo.spring.services.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

	private LibraryService libraryService;
	
	public LibraryController(LibraryService libraryService) {
		super();
		this.libraryService = libraryService;
	}


	@GetMapping(path="/books/{id}")
	public ResponseEntity<BookDTO> locateBook(@PathVariable String id){
		
		return ResponseEntity.ok(this.libraryService.getBook(id));
	}
}
