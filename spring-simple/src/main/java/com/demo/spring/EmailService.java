package com.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements NotificationService {

	public EmailService() {
		System.out.println("EmailService Object Created..");
	}
	@Override
	public void notify(String message) {
		System.out.println("Email Sent: "+message);

	}

}
