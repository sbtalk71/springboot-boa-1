package com.demo.spring.dao;

import java.util.List;
import java.util.Optional;

public interface MyJdbcRepository {

	public List<Book> findAll();
	public Optional<Book> save(Book book);
	public Optional<Book> update(Book book);
	public void delete(String isbn);
	public Optional<Book> findById(String isbn);
	
}
