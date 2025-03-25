package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.spring.entities.Book;
import com.demo.spring.exceptions.BookNotFoundException;
import com.demo.spring.repositories.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Book findBookById(String isbn) {
		Optional<Book> bookOp=bookRepository.findById(isbn);
		if(bookOp.isPresent()) {
			return bookOp.get();
		}else {
			throw new BookNotFoundException("Book with ISBN "+isbn+" not found");
		}
	}
	
}
