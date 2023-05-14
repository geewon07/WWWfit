package com.ssafy.wwwfit.model.dto;

public class Follow {
	private int followId;
	private String userId;
	private String followsWho;
	private String followDate;
	
	public Follow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Follow(String userId, String followsWho) {
		super();
		this.userId = userId;
		this.followsWho = followsWho;
	}

	public int getFollowId() {
		return followId;
	}

	public void setFollowId(int followId) {
		this.followId = followId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFollowsWho() {
		return followsWho;
	}

	public void setFollowsWho(String followsWho) {
		this.followsWho = followsWho;
	}

	public String getFollowDate() {
		return followDate;
	}

	public void setFollowDate(String followDate) {
		this.followDate = followDate;
	}
	
	

}
