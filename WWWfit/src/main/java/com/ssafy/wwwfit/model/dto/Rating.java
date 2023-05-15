package com.ssafy.wwwfit.model.dto;

public class Rating {
	private int ratingId;
	private String userId;
	private int contentSeq;
	private int score;
	private String review;//!! 이부분 추가??? `review` varchar(300)
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rating(String userId, int contentSeq, int score) {
		super();
		this.userId = userId;
		this.contentSeq = contentSeq;
		this.score = score;
	}
	public Rating(String userId, int contentSeq, int score, String review) {
		super();
		this.userId = userId;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	
	

}
