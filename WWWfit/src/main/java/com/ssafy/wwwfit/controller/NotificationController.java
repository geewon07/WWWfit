package com.ssafy.wwwfit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.storage.model.Notification;
import com.ssafy.wwwfit.model.service.NotificationService;

@RestController
@RequestMapping("/api_notification")
public class NotificationController {
	
	@Autowired
	private NotificationService nService;
	
	@GetMapping("/notification/{userNo}")
	public ResponseEntity<?> getUser(@PathVariable int userNo){
		List<Notification> notifications = nService.getNotification(userNo);
		return new ResponseEntity<List<Notification>>(notifications, HttpStatus.OK);
	}
}
