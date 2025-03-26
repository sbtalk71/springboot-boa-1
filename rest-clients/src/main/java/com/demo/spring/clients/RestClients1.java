package com.demo.spring.clients;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

public class RestClients1 {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();

		BookDTO response = restTemplate.getForObject("http://localhost:8181/books/224455", BookDTO.class);

		System.out.println(response);
		

		//RestClient restClient = RestClient.create();
		
		RestClient.Builder builder = RestClient.builder();
		
		BookDTO response1=builder.build().get()
				.uri("http://localhost:8181/books/12345")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(BookDTO.class);
		System.out.println(response1);
		
		
		List<BookDTO> response2=builder.build().get()
				.uri("http://localhost:8181/books/")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(new ParameterizedTypeReference<List<BookDTO>>() {});
			
		for(BookDTO book:response2) {
			System.out.println(book);
		}
	}

}
