package com.demo.spring.config;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.spring.dao.Book;
import com.demo.spring.repositories.BookRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class BookService2 {
	
	@PersistenceContext
	private EntityManager em;
	
	

	public void showAllBooks() {
		Query query=em.createQuery("select book from Book as book");
		List<Book> books=query.getResultList();
		
		for(Book book:books) {
			System.out.println(book);
		}
	}
	
}
