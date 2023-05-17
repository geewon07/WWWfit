package com.ssafy.wwwfit.model.dto;

public class Follow {
	private int followId;
	private int userNo;
	private int followsWho;
	private String followDate;
	
	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Follow(int userNo, int followsWho) {
		super();
		this.userNo = userNo;
		this.followsWho = followsWho;
	}

	public int getFollowId() {
		return followId;
	}

	public void setFollowId(int followId) {
		this.followId = followId;
	}

	public int getUserId() {
		return userNo;
	}

	public void setUserId(int userNo) {
		this.userNo = userNo;
	}

	public int getFollowsWho() {
		return followsWho;
	}

	public void setFollowsWho(int followsWho) {
		this.followsWho = followsWho;
	}

	public String getFollowDate() {
		return followDate;
	}

	public void setFollowDate(String followDate) {
		this.followDate = followDate;
	}
	
	

}
