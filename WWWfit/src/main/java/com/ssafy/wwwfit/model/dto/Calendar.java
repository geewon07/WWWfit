package com.ssafy.wwwfit.model.dto;

public class Calendar {
	private int calendarId;
	private String userId;
	private Boolean challenge;
	private String fitPartName;
	private String calendarStart;
	private String calendarEnd;
	
	public Calendar(int calendarId,String userId, Boolean challenge, String fitPartName, String calendarStart, String calendarEnd, String img) {
		super();
		this.calendarId = calendarId;
		this.userId = userId;
		this.challenge = challenge;
		this.fitPartName = fitPartName;
		this.calendarStart = calendarStart;
		this.calendarEnd = calendarEnd;
	}
    
	
	public Boolean getChallenge() {
		return challenge;
	}


	public void setChallenge(Boolean challenge) {
		this.challenge = challenge;
	}


	public String getFitPartName() {
		return fitPartName;
	}


	public void setFitPartName(String fitPartName) {
		this.fitPartName = fitPartName;
	}

	public Calendar() {
		super();
	}
    
	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		calendarId = calendarId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
	
	

}
