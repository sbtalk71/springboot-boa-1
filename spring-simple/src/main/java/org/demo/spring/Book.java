package org.demo.spring;

public class Book {

	private String isbn;
	private String name;
	private String author;

	public Book() {

	}

	public Book(String isbn, String name, String author) {
		this.isbn = isbn;
		this.name = name;
		this.author = author;
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