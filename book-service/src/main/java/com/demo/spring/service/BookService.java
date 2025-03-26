package com.demo.spring.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.spring.entities.Book;
import com.demo.spring.exceptions.BookExistsException;
import com.demo.spring.exceptions.BookNotFoundException;
import com.demo.spring.repositories.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;
	
	Logger logger=LoggerFactory.getLogger(this.getClass().getName());

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book findBookById(String isbn) {
		Optional<Book> bookOp = bookRepository.findById(isbn);
		if (bookOp.isPresent()) {
			logger.info("book found, returning to the controller");
			return bookOp.get();
		} else {
			logger.info("book not found, throwing exception");
			throw new BookNotFoundException("Book with ISBN " + isbn + " not found");
		}
	}

	public Book saveBook(Book book) {

		if (bookRepository.existsById(book.getIsbn())) {
			throw new BookExistsException("The book exists..");
		} else {
			return bookRepository.save(book);
		}
	}
	
	public String deleteBook(String isbn) {
		if(bookRepository.existsById(isbn)) {
			bookRepository.deleteById(isbn);
			return "Book Deleted";
		}else {
			throw new BookNotFoundException("Book Not Found");
		}
	}
	
	public Book updateBook(Book book) {
		if(bookRepository.existsById(book.getIsbn())) {
			return bookRepository.save(book);
		}else {
			throw new BookNotFoundException("Book Not Found");
		}
	}

}
