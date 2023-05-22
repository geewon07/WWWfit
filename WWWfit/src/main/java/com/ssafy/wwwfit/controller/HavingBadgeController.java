package com.ssafy.wwwfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/badge/{userNo}")
	public ResponseEntity<?> list(@PathVariable int userNo) {
		
		HavingBadge havingBadge = havingBadgeService.readHavingBadge(userNo);
		
		if(havingBadge == null) {
			return new ResponseEntity<String> ("뱃지가 하나도 없어요",HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity <HavingBadge> (havingBadge, HttpStatus.OK);
			// list로 반환하고있어서 vue에서 제대로 처리를 못해줬었다
		}
	}

}
