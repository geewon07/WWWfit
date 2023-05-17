package com.ssafy.wwwfit.model.service;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Calendar;

public interface CalendarService {
	
	// 캘린더 가져오기
	public List<Calendar> getCalendarList(int userNo);
	
	// 캘린더 등록하기
	public int addCalendartoday(int userNo, String fitPartName);
	
	// 캘린더 삭제하기
	public int removeCalendar(int calendarId);

}
