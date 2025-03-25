package com.demo.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository implements MyJdbcRepository {
	private JdbcTemplate jdbcTemplate;

	public BookRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Book> findAll() {
		/*
		 * List<Book> booksList=jdbcTemplate.query(new PreparedStatementCreator() {
		 * 
		 * @Override public PreparedStatement createPreparedStatement(Connection con)
		 * throws SQLException { PreparedStatement
		 * pst=con.prepareStatement("select * from book"); return pst; } }, new
		 * RowMapper<Book>() {
		 * 
		 * @Override public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		 * 
		 * return new Book(rs.getString("isbn"), rs.getString("name"),
		 * rs.getString("author"), rs.getString("genre")); } });
		 */

		List<Book> booksList = jdbcTemplate.query("select * from book", new BookRowMapper());
		return booksList;
	}

	@Override
	public Optional<Book> save(Book book) {

		if (this.findById(book.getIsbn()).isPresent()) {
			throw new BookExistsException("Book exists..");
		} else {
			int count = jdbcTemplate.update("insert into book(isbn,name,author,genre) values (?,?,?,?)", book.getIsbn(),
					book.getName(), book.getAuthor(), book.getGenre());
			if (count == 1) {
				return findById(book.getIsbn());
			} else {
				throw new RuntimeException("Error");
			}
		}

	}

	@Override
	public Optional<Book> update(Book book) {
		
			if (this.findById(book.getIsbn()).isPresent()) {
				int count = jdbcTemplate.update("update book set name=?,author=?,genre=?)", book.getName(),
						book.getAuthor(), book.getGenre());
				if (count == 1) {
					return findById(book.getIsbn());
				} else {
					throw new RuntimeException("Error");
				}
			} else {
				throw new BookNotFoundException("Book exists..");
			}
		
	}

	@Override
	public void delete(String isbn) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Book> findById(String isbn) {
		// Book book=new Book("0000","not available","NA","NA");
		try {
			Book book = jdbcTemplate.queryForObject("select * from book where isbn=?", new BookRowMapper(), isbn);
			return Optional.of(book);
		} catch (EmptyResultDataAccessException e) {
			// e.printStackTrace();
			return Optional.empty();
		}

	}

}

class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Book(rs.getString("isbn"), rs.getString("name"), rs.getString("author"), rs.getString("genre"));
	}
}
