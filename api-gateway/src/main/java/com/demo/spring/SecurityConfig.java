package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf(csrf->csrf.disable());
		http.authorizeHttpRequests(
				requests->requests.requestMatchers("/library/**").hasRole("USER")
				.requestMatchers("/books/**").hasRole("ADMIN").anyRequest().permitAll());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
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
