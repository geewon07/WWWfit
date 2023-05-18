package com.ssafy.wwwfit.model.dao;

public interface BadgesProgressDao {
	
	// 회원가입(사용자를 regist)할 때 bagesprogress table을 생성시키기 위한 메서드
	public int createBadgesprogress(int userNo);
	
	// count 수를 반환하는 것보다 여기서 증가를 시켜주고 따로 메서드를 만들어서 값을 가져온다
	public int fitPartNamecountupdate(int userNo, String fitPartName);
	
	// 이게 count 수
	public int getFitPartNamecount(int userNo, String fitPartName);
	
	// 삭제
	public int deleteUserBadgesProgress(int userNo);
	

}
