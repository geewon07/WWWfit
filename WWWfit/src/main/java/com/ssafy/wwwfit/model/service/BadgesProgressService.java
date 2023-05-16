package com.ssafy.wwwfit.model.service;

public interface BadgesProgressService {
	
	// 사용자 등록
	public int registBagesProgress(String userId);
	
	// 사용자가 완료한 챌린지의 fitpartName으로 등록
	public int updateBagesProgress(String userId, String fitPartName);

}
