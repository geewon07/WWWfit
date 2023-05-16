package com.ssafy.wwwfit.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.wwwfit.model.dto.HavingBadge;

public interface HavingBadgeDao {
	
	// 회원가입(사용자를 regist)할 때 bagesprogress table을 생성시키기 위한 메서드
	public int createHavingBadge(String userId);
	
	// userid에 따른 가지고 있는 뱃지 조회
	public List<HavingBadge> getHavingBadge(String userId);
	
	// userid와 뱃지이름에 따른 뱃지 등록  //우선 int 값으로 반환
	public int updateHavingBadge(HashMap<String, String> params);
}
