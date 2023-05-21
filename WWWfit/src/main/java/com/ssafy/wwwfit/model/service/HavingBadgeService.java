package com.ssafy.wwwfit.model.service;

import java.util.List;

import com.ssafy.wwwfit.model.dto.HavingBadge;

public interface HavingBadgeService {
	
	// 사용자 등록
	public int registHavingBadge(int userNo);
	
	// userid에 따른 가지고 있는 뱃지 조회
	public HavingBadge readHavingBadge(int userNo);
	
	public int deleteUserHavingBadge(int userNo) ;
	
}
