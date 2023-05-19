package com.ssafy.wwwfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.wwwfit.model.dto.Calendar;
import com.ssafy.wwwfit.model.service.BadgesProgressService;
import com.ssafy.wwwfit.model.service.CalendarService;

@RestController
@RequestMapping("/api_calendar")
public class CalendarController {
	
	@Autowired
	private CalendarService calendarService;
	@Autowired
	private BadgesProgressService badgesProgressService;
	
	@GetMapping("/calendar/{userNo}")
	public ResponseEntity<?> list(@PathVariable int userNo) {
		List<Calendar> list = calendarService.getCalendarList(userNo);
		
		if(list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Calendar>>(list,HttpStatus.OK); 
	}
	
	// 오늘 꺼를 등록하면 무엇을 반환할지는 미정! //오운완
	@PostMapping("/calendar")
	public ResponseEntity<?> write(int userNo, String fitPartName) {
		
		  int writedone = calendarService.addCalendartoday(userNo,fitPartName);
		  int updatefitPartNameCount = badgesProgressService.updateBagesProgress(userNo, fitPartName);
		
		if(writedone == 1 && updatefitPartNameCount == 1) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else if(writedone == 0 ){
			return new ResponseEntity<String>("캘린더에 등록되지 않음",HttpStatus.NOT_ACCEPTABLE);
		}else if(updatefitPartNameCount == 0) {
			return new ResponseEntity<String>("count가 업뎃되지 않음",HttpStatus.NOT_ACCEPTABLE);
		}else {
			return new ResponseEntity<String>("아무것도 되지 않음",HttpStatus.NOT_ACCEPTABLE);
		}
	}
    
	@DeleteMapping("/calendar/{id}")
	public ResponseEntity<?> delete(@PathVariable int calendarId) {
        int deletedone = calendarService.removeCalendar(calendarId);
		
		if(deletedone == 1) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
     }
}
