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
import com.ssafy.wwwfit.model.service.NotificationService;
import com.ssafy.wwwfit.model.service.UserService;

@RestController
@RequestMapping("/api_calendar")
public class CalendarController {
	
	@Autowired
	private CalendarService calendarService;
	@Autowired
	private BadgesProgressService badgesProgressService;
	@Autowired
	private UserService userService;
	@Autowired
	private NotificationService notificationService;
	
	
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
	public ResponseEntity<?> write(Calendar calendar) {
		  int writedone = calendarService.addCalendartoday(calendar);
		  int updatefitPartNameCount = badgesProgressService.updateBagesProgress(calendar.getUserNo(), calendar.getFitPartName());
		  // 자동생성된 calendar.getCalendarId값으로 => 오늘 날짜 반환해줌
		  String today = calendarService.gettoday(calendar.getCalendarId());
		  // 반환해준 오늘 날짜를 토대로 User의 연속 개수 count! ( userService에서!  ? )
		  userService.updatechallengedays(calendar.getUserNo(), today);
		  int challengedays = userService.getchallengedays(calendar.getUserNo());
		  if(challengedays != 0 && challengedays/4  == 0) {
			  userService.getExp(userService.getUser(calendar.getUserNo()), 5);
			  String context = "[경험치 5] 연속";
			  context += challengedays;
			  context += "회 운동을 달성하여 경험치 5를 획득하셨습니다.";
			  
			  notificationService.insertNotification(calendar.getUserNo(), context);
		  }
		if(writedone == 1 && updatefitPartNameCount == 1) {
			userService.getExp(userService.getUser(calendar.getUserNo()), 3);// 운동완료할때 경험치 올려주기
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
	
	@GetMapping("/calendar/{userNo}/{calendarStart}")
	public ResponseEntity<?> list(@PathVariable int userNo,@PathVariable String calendarStart) {
		int today = calendarService.gettodaychallenge(userNo, calendarStart);
		
		return new ResponseEntity<Integer>(today,HttpStatus.OK); 
	}
}
