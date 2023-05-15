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
import com.ssafy.wwwfit.model.service.CalendartService;

@RestController
@RequestMapping("/api_calendar")
public class CalendarController {
	
	@Autowired
	private CalendartService calendarService;
	
	@GetMapping("/calendar")
	public ResponseEntity<?> list(String userId) {
		List<Calendar> list = calendarService.getCalendarList(userId);
		
		if(list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Calendar>>(list,HttpStatus.OK); 
	}
	
	// 오늘 꺼를 등록하면 무엇을 반환할지는 미정!
	@PostMapping("/calendar")
	public ResponseEntity<Void> write(Calendar calendar) {
		
		  int wirtedone = calendarService.addCalendartoday(calendar);
		
		if(wirtedone == 1) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
    
	@DeleteMapping("/calendar/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
        int deletedone = calendarService.removeCalendar(id);
		
		if(deletedone == 1) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
     }
}
