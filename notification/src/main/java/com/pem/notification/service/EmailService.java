package com.pem.notification.service;

import com.pem.notification.model.Notification;

public interface EmailService {
	
	public boolean sendMessage(String to, String subject, Notification notification);

}
