package com.ssafy.wwwfit.model.dao;

import java.util.List;

import com.ssafy.wwwfit.model.dto.SearchCondition;
import com.ssafy.wwwfit.model.dto.User;

public interface UserDao {
	//CRUD =
	//회원 가입:유저 생성 ---> progress 도 생성시켜줘야 함 -->서비스? 매퍼?
	public int insert(User user);
	
	//회원 조회
	public List<User> selectAll();
	
	//회원 검색
	public List<User> searchBy(SearchCondition condition);
	
	//회원정보 수정, 경험치 증가, 등업, 챌린지 날
	public int update(User user);
	
//	public User login();//jwt 배우고 나서
	//회원탈퇴:정보삭제
	public int delete(String userId);
	
	//회원 경험치 증가
	
	

}
