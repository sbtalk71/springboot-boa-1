package com.demo.spring;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements NotificationService {

	@Override
	public void notify(String message) {
		System.out.println("Email Sent: "+message);

	}

}
