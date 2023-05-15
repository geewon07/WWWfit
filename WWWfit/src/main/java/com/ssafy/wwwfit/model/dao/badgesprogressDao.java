package com.ssafy.wwwfit.model.dao;

public interface badgesprogressDao {
	
	// 회원가입(사용자를 regist)할 때 bagesprogress table을 생성시키기 위한 메서드
	public int createBagesprogress(int userId);
	
	// count 수 update ( count 수를 반환하면 좋겠다!! )
	public int fitPartNamecountupdate(String userId, String fitPartName);
	

}
