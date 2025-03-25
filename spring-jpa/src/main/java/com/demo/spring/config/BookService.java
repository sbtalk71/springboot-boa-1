package com.demo.spring.config;

import org.springframework.stereotype.Service;

import com.demo.spring.dao.Book;
import com.demo.spring.repositories.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public void showAllBooks() {
		for(Book book:bookRepository.findAll()) {
			System.out.println(book);
		}
	}
	
}
