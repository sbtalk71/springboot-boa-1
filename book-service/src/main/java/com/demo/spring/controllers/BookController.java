package com.demo.spring.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.BookService;
import com.demo.spring.entities.Book;

@RestController
@RequestMapping("/books")
public class BookController {

	
	private BookService bookService;
	
	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}


	@GetMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Book>> getAll(){
		return ResponseEntity.ok(bookService.getAllBooks());
	}
	
	@GetMapping(path="/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
		return ResponseEntity.ok(bookService.findBookById(isbn));
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.saveBook(book));
	}
	
}
