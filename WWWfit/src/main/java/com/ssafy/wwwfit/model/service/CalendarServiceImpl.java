package com.ssafy.wwwfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.wwwfit.model.dao.BadgesProgressDao;
import com.ssafy.wwwfit.model.dao.CalendarDao;
import com.ssafy.wwwfit.model.dto.Calendar;

@Service
public class CalendarServiceImpl implements CalendarService {
    
	@Autowired
	private CalendarDao calendarDao;
	
	@Override
	public List<Calendar> getCalendarList(int userNo) {
		return calendarDao.getCalendar(userNo);
	}

	@Override
	public int addCalendartoday(int userNo, String fitPartName) {
		return calendarDao.createcalendar(userNo,fitPartName);
	}

	@Override
	public int removeCalendar(int calendarId) {
		return calendarDao.deletecalendar(calendarId);
	}

}
