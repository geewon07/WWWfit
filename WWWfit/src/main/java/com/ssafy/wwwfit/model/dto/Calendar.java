package com.ssafy.wwwfit.model.dto;

public class Calendar {
	private int CalendarId;
	private String userId;
	private Boolean execisedone;
	private String calendarStart;
	private String calendarEnd;
	
	public Calendar(int calendarId,String userId, Boolean execisedone, String calendarStart, String calendarEnd, String img) {
		super();
		this.CalendarId = calendarId;
		this.userId = userId;
		this.execisedone = execisedone;
		this.calendarStart = calendarStart;
		this.calendarEnd = calendarEnd;
	}
    
	public Calendar() {
		super();
	}
    
	public int getCalendarId() {
		return CalendarId;
	}

	public void setCalendarId(int calendarId) {
		CalendarId = calendarId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getExecisedone() {
		return execisedone;
	}

	public void setExecisedone(Boolean execisedone) {
		this.execisedone = execisedone;
	}

	public String getCalendarStart() {
		return calendarStart;
	}

	public void setCalendarStart(String calendarStart) {
		this.calendarStart = calendarStart;
	}

	public String getCalendarEnd() {
		return calendarEnd;
	}

	public void setCalendarEnd(String calendarEnd) {
		this.calendarEnd = calendarEnd;
	}

	@Override
	public String toString() {
		return "CalendarDao [userId=" + userId + ", execisedone=" + execisedone + ", calendarStart=" + calendarStart
				+ ", calendarEnd=" + calendarEnd + "]";
	}
	
	

}
