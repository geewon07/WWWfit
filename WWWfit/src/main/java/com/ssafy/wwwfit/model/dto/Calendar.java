package com.ssafy.wwwfit.model.dto;

public class Calendar {
	private int calendarId;
	private int userNo;
	private Boolean challenge;
	private String fitPartName;
	private String calendarStart;
	
	public Calendar(int calendarId,int userNo, Boolean challenge, String fitPartName, String calendarStart) {
		super();
		this.calendarId = calendarId;
		this.userNo = userNo;
		this.challenge = challenge;
		this.fitPartName = fitPartName;
		this.calendarStart = calendarStart;
	}
	
	public Calendar(int userNo, String fitPartName) {
		super();
		this.userNo = userNo;
		this.fitPartName = fitPartName;
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
		this.calendarId = calendarId;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
    
	public String getCalendarStart() {
		return calendarStart;
	}

	public void setCalendarStart(String calendarStart) {
		this.calendarStart = calendarStart;
	}

	

}
