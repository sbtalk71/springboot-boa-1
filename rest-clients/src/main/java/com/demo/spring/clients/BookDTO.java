package com.demo.spring.clients;


public class BookDTO {

	private String isbn;
	private String name;
	private String author;
	private String genre;
	public BookDTO() {
		// TODO Auto-generated constructor stub
	}
	public BookDTO(String isbn, String name, String author, String genre) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.author = author;
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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "BookDTO [isbn=" + isbn + ", name=" + name + ", author=" + author + ", genre=" + genre + "]";
	}
	
	
}
