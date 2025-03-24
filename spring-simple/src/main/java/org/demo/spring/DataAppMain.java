package org.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DataAppMain {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(DataAppConfig.class);
		
		BookService bookService=ctx.getBean("bookService",BookService.class);
		
		Book book=new Book("123456","Harry Potter","JK Rowling");
		
		String resp=bookService.addBook(book);
		System.out.println(resp);

	}

}
