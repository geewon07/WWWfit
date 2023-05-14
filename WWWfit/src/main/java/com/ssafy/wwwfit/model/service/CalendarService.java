package com.ssafy.wwwfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.wwwfit.model.dao.CalendarDao;
import com.ssafy.wwwfit.model.dto.Calendar;

@Service
public class CalendarService implements CalendartServiceImpl {
    
	private CalendarDao calendarDao;
	
	@Autowired
	public void setCalendarDao(CalendarDao calendarDao) {
		this.calendarDao = calendarDao;
	}
	
	@Override
	public List<Calendar> getCalendarList() {
		return calendarDao.getCalendar();
	}

	@Override
	public int addCalendartoday(Calendar calendar) {
		return calendarDao.createcalendar(calendar);
	}

	@Override
	public int removeCalendar(int calendarId) {
		return calendarDao.deletecalendar(calendarId);
	}

}
