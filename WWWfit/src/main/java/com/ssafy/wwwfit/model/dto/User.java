package com.ssafy.wwwfit.model.dto;

public class User {
	private int userNo;
	private String userId;
	private String password;
	private String name;
	private String email;
	private String img;
	private String userRank;
	private int experience;
	private int challengedays;
	private String regDate;
	private String token="";
//	private int token;//kko login token user serial number
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userId, String password, String name) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
	}
	public User(String userId, String password, String name, String email, String img) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.img = img;
	}
	
	public User(String userId, String password, String name, String email, String img, String token) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.img = img;
		this.token = token;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getUserRank() {
		return userRank;
	}
	public void setUserRank(String userRank) {
		this.userRank = userRank;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getChallengedays() {
		return challengedays;
	}
	public void setChallengedays(int challengedays) {
		this.challengedays = challengedays;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
	
	
}
