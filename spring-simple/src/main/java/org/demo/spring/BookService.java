package org.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService{
	
	private DataRepository bookRepository;
	
	@Autowired
	public BookService(DataRepository bookRepository) {
		this.bookRepository=bookRepository;
	}

	public String addBook(Book book){

	String resp=bookRepository.save(book);
	return resp;
	}
	
	


}