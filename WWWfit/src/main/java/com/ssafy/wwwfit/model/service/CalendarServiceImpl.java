package com.ssafy.wwwfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ssafy.wwwfit.model.dao.BadgesProgressDao;
import com.ssafy.wwwfit.model.dao.CalendarDao;
import com.ssafy.wwwfit.model.dao.NotificationDao;
import com.ssafy.wwwfit.model.dto.Calendar;

@Service
public class CalendarServiceImpl implements CalendarService {
    
	@Autowired
	private CalendarDao calendarDao;
	@Autowired
	private NotificationDao notificationDao;
	
	@Override
	public List<Calendar> getCalendarList(int userNo) {
		return calendarDao.getCalendar(userNo);
	}

	@Override
	public int addCalendartoday(Calendar calendar) {
		String context = "";
		context += "[챌린지] 오늘 운동 완료하여 경험치 3을 획득하셨습니다.";
		notificationDao.insertNotification(calendar.getUserNo(), context);
		return calendarDao.createcalendar(calendar);
	}

	@Override
	public int removeCalendar(int calendarId) {
		return calendarDao.deletecalendar(calendarId);
	}

	@Override
	public String getCalendarDay(int userNo, String calendarStart) {
		return calendarDao.getCalendarDay(userNo, calendarStart);
	}

	@Override
	public String gettoday(int calendarId) {
		return calendarDao.gettoday(calendarId);
	}

	@Override
	public int gettodaychallenge(int userNo, String calendarStart) {
		return calendarDao.gettodaychallenge(userNo, calendarStart);
	}
	
}
