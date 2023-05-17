package com.ssafy.wwwfit.model.service;

public interface BadgesProgressService {
	
	// 사용자 등록
	public int registBagesProgress(int userNo);
	
	// 사용자가 완료한 챌린지의 fitpartName으로 등록
	public int updateBagesProgress(int userNo, String fitPartName);

}
