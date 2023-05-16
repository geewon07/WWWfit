package com.ssafy.wwwfit.model.dto;

public class User {
	private String userId;
	private String password;
	private String name;
	private String email;
	private String img;
	private String userRank;
	private int experience;
	private int challengeDays;
	private String regDate;
	private int sub;//kko login token user serial number
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
	
	public User(String userId, String password, String name, String email, String img, int sub) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.img = img;
		this.sub = sub;
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
	public int getChallengeDays() {
		return challengeDays;
	}
	public void setChallengeDays(int challengeDays) {
		this.challengeDays = challengeDays;
	}
	public int getSub() {
		return sub;
	}
	public void setSub(int sub) {
		this.sub = sub;
	}
	
	
	
	
}
