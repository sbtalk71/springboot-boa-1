package com.demo.spring.clients;

import java.io.IOException;
import java.util.Base64;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ClientCustomeInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		String encodeCredentials=new String(Base64.getEncoder().encode("pavan:welcome1".getBytes()));
		
		request.getHeaders().add("Authorization", "Basic "+encodeCredentials);
		return execution.execute(request, body);
	}

}
