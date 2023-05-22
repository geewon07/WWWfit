package com.ssafy.wwwfit.model.dto;

public class Notification {
	// 경험치가 update할 때 알림 추가해주기
	private int userNo;
	private int NotificationNo;
	private String context;
	private String regDate;
	
	public Notification(int userNo, int notificationNo, String context, String regDate) {
		super();
		this.userNo = userNo;
		NotificationNo = notificationNo;
		this.context = context;
		this.regDate = regDate;
	}
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getNotificationNo() {
		return NotificationNo;
	}
	public void setNotificationNo(int notificationNo) {
		NotificationNo = notificationNo;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
	
	
	

}
