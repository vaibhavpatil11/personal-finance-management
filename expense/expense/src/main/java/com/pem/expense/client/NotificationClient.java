package com.pem.expense.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pem.expense.model.Notification;

@FeignClient(value = "notification", url = "http://localhost:8088")
public interface NotificationClient {

	@PostMapping("/api/notification/sendMessage")
	boolean sendNotification(@RequestBody Notification notification);

}
