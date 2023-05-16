package com.ssafy.wwwfit.model.dto;

public class Poster {
	private int posterSeq;
	private String title;
	private int difficulty;
	private String fitPartName;
	private String posterSrc;
	private	int likeCount;// int default 0;수정해야 함!!
	public Poster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Poster(String title, int difficulty, String fitPartName, String posterSrc) {
		super();
		this.title = title;
		this.difficulty = difficulty;
		this.fitPartName = fitPartName;
		this.posterSrc = posterSrc;
	}
	public int getPosterSeq() {
		return posterSeq;
	}
	public void setPosterSeq(int posterSeq) {
		this.posterSeq = posterSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public String getFitPartName() {
		return fitPartName;
	}
	public void setFitPartName(String fitPartName) {
		this.fitPartName = fitPartName;
	}
	public String getPosterSrc() {
		return posterSrc;
	}
	public void setPosterSrc(String posterSrc) {
		this.posterSrc = posterSrc;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	


	
	
}
