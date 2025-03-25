package com.demo.spring.config;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.dao.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class JpaMain {

	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(JpaAppConfig.class);
		
		EntityManagerFactory emf= (EntityManagerFactory)ctx.getBean(EntityManagerFactory.class);
		EntityManager em=emf.createEntityManager();
		EntityTransaction tx= em.getTransaction();
		try {
			tx.begin();
			Book book= new Book("12345","Demo","Demo Auther","Thriller");
			em.persist(book);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

}
