package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	private NotificationService notificationService;
	
	
	public void sendMessage(String message) {
		notificationService.notify(message);
	}
	
	@Autowired
	public UserService(NotificationService notificationService) {
		this.notificationService=notificationService;
	}
	
}
