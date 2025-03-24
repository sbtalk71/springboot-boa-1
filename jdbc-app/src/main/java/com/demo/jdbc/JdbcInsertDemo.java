package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsertDemo {

	public static void main(String[] args) {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "root");) {
			PreparedStatement pst = conn.prepareStatement("insert into book(isbn,name,author,genre) values(?,?,?,?)");
			pst.setString(1, "546655");
			pst.setString(2, "No Time To Die");
			pst.setString(3, "Ian Fleming");
			pst.setString(4, "thriller");

			int updatedRows = pst.executeUpdate();

			System.out.println("Rows inserted : " + updatedRows);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
