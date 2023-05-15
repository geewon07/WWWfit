package com.ssafy.wwwfit.model.dto;

public class Like {
	private int likeId;
	private int posterSeq;
	private String userId;
	private String likeDate;
	
	public Like() {
	}
	public Like(int posterSeq, String userId) {
		super();
		this.posterSeq = posterSeq;
		this.userId = userId;
	}
	public int getLikeId() {
		return likeId;
	}
	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}
	public int getPosterSeq() {
		return posterSeq;
	}
	public void setPosterSeq(int posterSeq) {
		this.posterSeq = posterSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(String likeDate) {
		this.likeDate = likeDate;
	}
	
	
	

}
