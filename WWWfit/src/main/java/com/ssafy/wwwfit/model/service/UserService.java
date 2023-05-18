package com.ssafy.wwwfit.model.service;

import java.util.List;

import com.ssafy.wwwfit.model.dto.SearchCondition;
import com.ssafy.wwwfit.model.dto.User;

public interface UserService {
	//회원 가입
	//유저 생성시 같이 병행하는 것: 배지 소유목록 초기화, 뱃지 경과 초기화, 환경설정 초기화,
	public int regist(User user);
	
	//회원 조회
	public List<User> getUsers();
	
	public List<User> searchUser(SearchCondition condition);
	
	public User getUser(int userNo);
	// 로그인~~~  jwt
	public Integer login(String userId, String password);
	
//	public int loginUser(String userId, String password);
	//회원 정보 수정
	public int updateInfo(User user);
	//경험치 조정(부여, 회수)
	public int getExp(User user, int points);
	//등급 조정
//	public int rankUp(User user);
	//챌린지- 연속일수 조정
	public int challengeProgress(User user);
	
	///프로그레스 초기화는 어디서 해야할지?
	
	//회원 탈퇴
	public int quit(int userNo);
	
	
}
