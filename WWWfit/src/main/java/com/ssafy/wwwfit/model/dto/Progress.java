package com.ssafy.wwwfit.model.dto;

public class Progress {//badgesprogress ---> create 1 when user gets created
	
	private int badgesNo;
	private String userId;
	private int neck;
	private int shoulder;
	private int back;
	private int hand;
	private int eye;
	private int leg;
	public Progress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBadgesNo() {
		return badgesNo;
	}
	public void setBadgesNo(int badgesNo) {
		this.badgesNo = badgesNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getNeck() {
		return neck;
	}
	public void setNeck(int neck) {
		this.neck = neck;
	}
	public int getShoulder() {
		return shoulder;
	}
	public void setShoulder(int shoulder) {
		this.shoulder = shoulder;
	}
	public int getBack() {
		return back;
	}
	public void setBack(int back) {
		this.back = back;
	}
	public int getHand() {
		return hand;
	}
	public void setHand(int hand) {
		this.hand = hand;
	}
	public int getEye() {
		return eye;
	}
	public void setEye(int eye) {
		this.eye = eye;
	}
	public int getLeg() {
		return leg;
	}
	public void setLeg(int leg) {
		this.leg = leg;
	}
	
	

}
