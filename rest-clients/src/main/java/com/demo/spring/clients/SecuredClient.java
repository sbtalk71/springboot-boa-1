package com.demo.spring.clients;

import java.util.Base64;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

public class SecuredClient {

	public static void main(String[] args) {
		
		String encodeCredentials=new String(Base64.getEncoder().encode("shantanu:welcome1".getBytes()));
		System.out.println(encodeCredentials);
		//RestClient client=RestClient.create();
		
		RestClient.Builder builder=RestClient.builder();
		builder.requestInterceptor(new ClientCustomeInterceptor());
		
		BookDTO book=builder.build().get()
				.uri("http://localhost:9000/library/books/224455")
				.accept(MediaType.APPLICATION_JSON)
				//.header("Authorization", "Basic "+encodeCredentials)
				.retrieve()
				.body(BookDTO.class);
		
		System.out.println(book);

	}

}
