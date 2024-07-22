package com.pem.notification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.pem.notification.model.Notification;
import com.pem.notification.service.EmailService;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender emailSender;

	@Override
	public boolean sendMessage(String to, String subject, Notification notification) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("noreply@baeldung.com");
			message.setTo(to);
			message.setSubject(subject);
			message.setText(notification.toString());
			emailSender.send(message);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}
}