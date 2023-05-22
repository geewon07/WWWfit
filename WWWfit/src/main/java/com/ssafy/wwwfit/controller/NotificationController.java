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
@RequestMapping("/api_Notification")
public class NotificationController {
	
	@Autowired
	private NotificationService nService;
	
	@GetMapping("/Notification/{userNo}")
	public ResponseEntity<?> getUser(@PathVariable int userNo){
		List<Notification> notifications = nService.getNotification(userNo);
		if(notifications==null | notifications.size() == 0) {
			return new ResponseEntity<String>("알림없음",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Notification>>(notifications, HttpStatus.OK);
	}
}
