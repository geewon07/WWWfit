package com.ssafy.wwwfit.model.dto;

public class Bookmark {
	private int bookmarkId;
	private int posterSeq;
	private String userId;
	private String bName ="default";// bookmark folder? default 'default'
	private boolean isPublic =true; // !!db 추가하기 공개설정
	//	private String comment;//추가?
	
	public Bookmark() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bookmark(int posterSeq, String userId, String bName) {
		super();
		this.posterSeq = posterSeq;
		this.userId = userId;
		this.bName = bName;
	}
	
	
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	public int getBookmarkId() {
		return bookmarkId;
	}
	public void setBookmarkId(int bookmarkId) {
		this.bookmarkId = bookmarkId;
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
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	
	
	
	

}
