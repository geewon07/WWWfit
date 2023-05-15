package com.ssafy.wwwfit.model.dao;

import com.ssafy.wwwfit.model.dto.Havingbadge;

public interface HavingbadgeDao {
	
	// userid에 따른 조회
	public Havingbadge getHavingBadge(String userId);
}
