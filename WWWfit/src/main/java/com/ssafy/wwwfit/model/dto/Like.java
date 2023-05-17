package com.ssafy.wwwfit.model.dto;

public class Like {
	private int likeId;
	private int posterSeq;
	private int userNo;
	private String likeDate;
	
	public Like() {
	}
	public Like(int posterSeq, int userNo) {
		super();
		this.posterSeq = posterSeq;
		this.userNo = userNo;
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
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(String likeDate) {
		this.likeDate = likeDate;
	}
	
	
	

}
