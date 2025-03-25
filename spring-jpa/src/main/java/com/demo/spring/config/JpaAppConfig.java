package com.demo.spring.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
@EnableJpaRepositories(basePackages = "com.demo.spring.repositories")
public class JpaAppConfig {

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
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lcb= new LocalContainerEntityManagerFactoryBean();
		lcb.setDataSource(dataSource());
		lcb.setPersistenceUnitName("customJpa");
		lcb.setPackagesToScan("com.demo.spring.dao");
		
		HibernateJpaVendorAdapter va= new HibernateJpaVendorAdapter();
		va.setDatabase(Database.MYSQL);
		va.setShowSql(true);
		
		lcb.setJpaVendorAdapter(va);
		
		return lcb;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager tx=new JpaTransactionManager();
		tx.setEntityManagerFactory(entityManagerFactory().getObject());
		return tx;
	}
	
	
}
