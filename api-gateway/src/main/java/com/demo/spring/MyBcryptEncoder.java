package com.demo.spring;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyBcryptEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		System.out.println(encoder.encode("welcome1"));

	}

}
