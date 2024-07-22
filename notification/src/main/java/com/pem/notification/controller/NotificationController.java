package com.pem.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pem.notification.service.EmailService;


@RestController
@RequestMapping("/api/notification")
public class NotificationController {
	
	
	@Autowired
	EmailService emailService;

	@PostMapping("/sendMessage")
	boolean sendNotification(@RequestBody com.pem.notification.model.Notification notification) {
		return emailService.sendMessage("test@gmai.com", "user@gmail.com", notification);

	}

}
