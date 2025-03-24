package com.demo.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcQueryDemo {

	public static void main(String[] args) throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "root");
		
		/*
		 * Statement stmt=conn.createStatement();
		 * 
		 * ResultSet rs=stmt.executeQuery("select * from book");
		 */
		
		PreparedStatement pst=conn.prepareStatement("select * from book");
		
		ResultSet rs= pst.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString("isbn")+" "+rs.getString("name")+" "+rs.getString("author")+" "+rs.getString("genre"));
		}

	}

}
