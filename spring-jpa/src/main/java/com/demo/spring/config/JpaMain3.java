package com.demo.spring.config;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.dao.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.StoredProcedureQuery;

public class JpaMain3 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaAppConfig.class);

		BookService2 service=ctx.getBean(BookService2.class);
		
		service.showAllBooks();

	}

}
