package com.ssafy.wwwfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.wwwfit.model.dto.HavingBadge;
import com.ssafy.wwwfit.model.service.HavingBadgeService;

@RestController
@RequestMapping("/api_badge")
public class HavingBadgeController {
	
	@Autowired
	private HavingBadgeService havingBadgeService;
	
	// 뱃지 전체 조회
	@GetMapping("/badge")
	public ResponseEntity<?> list(String userId) {
		
		List<HavingBadge> list = havingBadgeService.readHavingBadge(userId);
		
		if(list == null || list.size() == 0) {
			return new ResponseEntity<String> ("뱃지가 하나도 없어요",HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<HavingBadge>> (list, HttpStatus.OK);
		}
	}

}
