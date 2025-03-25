package com.demo.spring;

import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demo.spring.config.JdbcAppConfig;
import com.demo.spring.dao.Book;
import com.demo.spring.dao.BookRepository;

public class JdbcDaoMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcAppConfig.class);
		BookRepository bookRepository=(BookRepository)ctx.getBean("bookRepository");
		
		/*
		 * for(Book book:bookRepository.findAll()) { System.out.println(book); }
		 */
		
		/*
		 * Optional<Book> bookOp= bookRepository.findById("112033");
		 * if(bookOp.isPresent()) { System.out.println(bookOp.get()); }else {
		 * System.out.println("No Book Found"); }
		 */
		
		Book book= new Book("112233","Romeo and Juliet","Shakespeare","romance");
	}

}
