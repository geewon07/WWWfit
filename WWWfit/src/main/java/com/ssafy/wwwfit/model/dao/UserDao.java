package com.ssafy.wwwfit.model.dao;

import java.util.List;

import com.ssafy.wwwfit.model.dto.SearchCondition;
import com.ssafy.wwwfit.model.dto.User;

public interface UserDao {
	//CRUD =
	//회원 가입:유저 생성 ---> progress 도 생성시켜줘야 함 -->서비스? 매퍼?
	public int insert(User user);
	
	public int insert_kakao(User user);
	//회원 조회
	public List<User> selectAll();
	
	public User selectOne(int userNo);
	
	//회원 검색
	public List<User> searchBy(SearchCondition condition);
	
	//수정하기 위해서 유저정보를 전부 불러와야 함,,,
	//회원정보 수정, 경험치 증가, 등업, 챌린지 날
	public int update(User user);
	
	public Integer login(String userId, String password);//jwt 배우고 나서
	//회원탈퇴:정보삭제
	public int delete(int userNo);
	
	//회원 경험치 증가
	
	// 연속 개수 update
	public int updatechallengedays(int userNo, int challengedays, int check);
	
	// 연속 개수 반납
	public int getchallengedays(int userNo);
	
	// 토큰 업데이트 ( 로그인시 )
	public int updateTokenFirebase(int userNo, String token);
	
	// 모든 유저의 토큰 가져오기
	public List<String> gettokens();
	
	public int getUserId(String userId);

}
