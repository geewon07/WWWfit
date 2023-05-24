package com.ssafy.wwwfit.model.dto;

public class Rating {
	private int ratingId;
	private int userNo;
	private int contentSeq;
	private int score;
	private String review;//!! 이부분 추가??? `review` varchar(300)
	private String RegDate;
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(int userNo, int contentSeq, int score) {
		super();
		this.userNo = userNo;
		this.contentSeq = contentSeq;
		this.score = score;
	}
	
	public Rating(int userNo, int contentSeq, int score, String review) {
		super();
		this.userNo = userNo;
		this.contentSeq = contentSeq;
		this.score = score;
		this.review = review;
	}
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getContentSeq() {
		return contentSeq;
	}
	public void setContentSeq(int contentSeq) {
		this.contentSeq = contentSeq;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getRegDate() {
		return RegDate;
	}
	public void setRegDate(String regDate) {
		RegDate = regDate;
	}
	
	
	

}
