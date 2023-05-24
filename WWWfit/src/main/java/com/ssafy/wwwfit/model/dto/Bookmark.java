package com.ssafy.wwwfit.model.dto;

public class Bookmark {
	private int bookmarkId;
	private String posterSeq;
	private int userNo;
	private String description="";
	private String bname;// bookmark folder? default 'default'
	private boolean isPublic =true; // !!db 추가하기 공개설정
	private String regDate;
	//	private String comment;//추가?
	
	public Bookmark() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public Bookmark(String posterSeq, int userNo, String bname) {
//		super();
//		this.posterSeq = posterSeq;
//		this.userNo = userNo;
//		this.bname = bname;
//	}
//	public Bookmark(String posterSeq, int userNo) {
//		super();
//		this.posterSeq = posterSeq;
//		this.userNo = userNo;
//	}
//	public Bookmark(String posterSeq, int userNo, String description, String bname) {
//		super();
//		this.posterSeq = posterSeq;
//		this.userNo = userNo;
//		this.description = description;
//		this.bname = bname;
//	}
	public int getBookmarkId() {
		return bookmarkId;
	}
	public void setBookmarkId(int bookmarkId) {
		this.bookmarkId = bookmarkId;
	}
	public String getPosterSeq() {
		return posterSeq;
	}
	public void setPosterSeq(String posterSeq) {
		this.posterSeq = posterSeq;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getbname() {
		return bname;
	}
	public void setbname(String bname) {
		this.bname = bname;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	@Override
	public String toString() {
		return "Bookmark [bookmarkId=" + bookmarkId + ", posterSeq=" + posterSeq + ", userNo=" + userNo
				+ ", description=" + description + ", bname=" + bname + ", isPublic=" + isPublic + "]";
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
	

	
	
	

}
