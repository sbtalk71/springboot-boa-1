package com.demo.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
		List<Book> booksList=jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst=con.prepareStatement("select * from book");
				return pst;
			}
		}, new RowMapper<Book>() {
			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new Book(rs.getString("isbn"), 
						rs.getString("name"), rs.getString("author"), rs.getString("genre"));
			}
		});
		return booksList;
	}

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book update(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String isbn) {
		// TODO Auto-generated method stub

	}

	@Override
	public Book findById(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

}
