package com.ssafy.wwwfit.model.dto;

public class Like {
	private int likeposterId;
	private int posterSeq;
	private int userNo;
	private String likedate;
	
	public Like() {
	}
	public Like(int posterSeq, int userNo) {
		super();
		this.posterSeq = posterSeq;
		this.userNo = userNo;
	}
	public int getLikeposterId() {
		return likeposterId;
	}
	public void setLikeposterId(int likeposterId) {
		this.likeposterId = likeposterId;
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
	public String getLikedate() {
		return likedate;
	}
	public void setLikedate(String likedate) {
		this.likedate = likedate;
	}
	
	
	

}
