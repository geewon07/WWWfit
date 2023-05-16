package com.ssafy.wwwfit.model.dto;

public class badgesProgress {
	private int badgesNo;
	private String userId;
	private int neck;
	private int shoulder;
	private int back;
	private int hand;
	private int eye;
	private int leg;
	
	public badgesProgress(int badgesNo, String userId, int neck, int shoulder, int back, int hand, int eye, int leg) {
		super();
		this.badgesNo = badgesNo;
		this.userId = userId;
		this.neck = neck;
		this.shoulder = shoulder;
		this.back = back;
		this.hand = hand;
		this.eye = eye;
		this.leg = leg;
	}
	public badgesProgress() {
		super();
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
