package com.ssafy.wwwfit.model.dto;

public class Bookmark {
	private int bookmarkId;
	private int posterSeq;
	private int userNo;
	private String bName ="default";// bookmark folder? default 'default'
	private boolean isPublic =true; // !!db 추가하기 공개설정
	//	private String comment;//추가?
	
	public Bookmark() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bookmark(int posterSeq, int userNo, String bName) {
		super();
		this.posterSeq = posterSeq;
		this.userNo = userNo;
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
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	
	
	
	

}
