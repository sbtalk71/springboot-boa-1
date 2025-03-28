package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@GetMapping("/library-fallback")
	public String message() {
		return "Library Service not available";
	}
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager userManager= new InMemoryUserDetailsManager();
		userManager.createUser(User.withUsername("shantanu").password("$2a$10$2FQjFgmQfH.N9TQuTPKX5.HTdRnF4aD0WcWjau3ckGki/dbwdVSme").roles("ADMIN").build());
		userManager.createUser(User.withUsername("pavan").password("$2a$10$2FQjFgmQfH.N9TQuTPKX5.HTdRnF4aD0WcWjau3ckGki/dbwdVSme").roles("USER").build());
		userManager.createUser(User.withUsername("ranga").password("$2a$10$2FQjFgmQfH.N9TQuTPKX5.HTdRnF4aD0WcWjau3ckGki/dbwdVSme").roles("CLIENT").build());
		return userManager;
	}
}
