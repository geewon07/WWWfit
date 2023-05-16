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
	public List<Calendar> getCalendarList(String userId) {
		return calendarDao.getCalendar(userId);
	}

	@Override
	public int addCalendartoday(String userId, String fitPartName) {
		return calendarDao.createcalendar(userId,fitPartName);
	}

	@Override
	public int removeCalendar(int calendarId) {
		return calendarDao.deletecalendar(calendarId);
	}

}
