package com.ssafy.wwwfit.model.dao;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Calendar;

public interface CalendarDao {
	
	// 캘린더 전체 가져오기
	public List<Calendar> getCalendar();
	
	// 캘린더 등록하기 ( 등록했다면 숫자 1 반환 )
	public int createcalendar(Calendar calendar);
	
	// 캘린더 삭제하기
	public int deletecalendar(int calendarId);
	
	

}
