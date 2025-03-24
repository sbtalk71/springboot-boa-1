package com.demo.spring.dao;

public class Book {

	private String isbn;
	private String name;
	private String author;
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