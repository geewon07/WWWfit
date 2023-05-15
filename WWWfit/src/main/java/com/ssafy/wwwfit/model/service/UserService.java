package com.ssafy.wwwfit.model.service;

import java.util.List;

import com.ssafy.wwwfit.model.dto.SearchCondition;
import com.ssafy.wwwfit.model.dto.User;

public interface UserService {
	//회원 가입
	public int regist(User user);
	//회원 조회
	public List<User> getUsers();
	
	public List<User> searchUser(SearchCondition condtion);
	
	// 로그인~~~  jwt
	
	//회원 정보 수정
	public int updateInfo(User user);
	//경험치 조정(부여, 회수)
	public int getExp(User user);
	//등급 조정
	public int rankUp(User user);
	//챌린지- 연속일수 조정
	public int challengeProgress(User user);
	
	//회원 탈퇴
	public int quit(User user);
	
	
}
