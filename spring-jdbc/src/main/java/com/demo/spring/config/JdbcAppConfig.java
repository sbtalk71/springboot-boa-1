package com.demo.spring.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
public class JdbcAppConfig {

	@Bean
	public DataSource dataSource() {
		//DriverManagerDataSource ds=new DriverManagerDataSource();
		BasicDataSource ds= new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/librarydb");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setInitialSize(10);
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		JdbcTemplate jt=new JdbcTemplate(ds);
		return jt;
	}
	
	@Bean
	public JdbcClient jdbcClient(DataSource ds) {
		JdbcClient client= JdbcClient.create(ds);
		return client;
	}
}
