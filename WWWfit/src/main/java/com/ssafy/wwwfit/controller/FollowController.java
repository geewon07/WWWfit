package com.ssafy.wwwfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.wwwfit.model.service.FollowService;


@RestController
@RequestMapping("/api_follow")
public class FollowController {
	
	@Autowired
	private FollowService followService;
	
	@GetMapping()

}
