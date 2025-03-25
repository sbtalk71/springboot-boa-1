package com.demo.spring.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book {

	@Id
	@Column(name="ISBN")
	private String isbn;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AUTHOR")
	private String author;
	
	@Column(name="GENRE")
	private String genre;

	public Book() {

	}

	public Book(String isbn, String name, String author,String genre) {
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.genre=genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		
		return "["+isbn+" "+name+" "+author+"]";
	}

}