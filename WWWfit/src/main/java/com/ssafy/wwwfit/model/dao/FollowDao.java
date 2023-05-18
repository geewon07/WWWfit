package com.ssafy.wwwfit.model.dao;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Follow;
//설정창에 추가할것, 팔로우 허락? 마이페이지 공개범위
//follow내부에는 유저 아이디 정보가 있어서--> 클릭시 회원페이지(--> 설정에서 공개범위설정)
// 다른 회원 페이지에 팔로우 버튼 노출하기/ 팔로우상태 체크할 수 있어야함
public interface FollowDao {
	// 둘다 시간순으로 가장 먼저 팔로우 한 사람이 상단에 위치하도록?
	
	// 현재 유저가 팔로우하는 유저 목록 // select followsWho from follows where userId=#{userId};	
	public List<Follow> selectFollows(int userNo);
	//매퍼에서 차이--> select userId from follows where followsWho=#{userId};
	public List<Follow> selectFollowers(int userNo);
	//dao? service?
	
	public Follow selectOne(int followId);
	// 위 메소드로 얻은 list.size() 하면 되는 것 아닐까?
//	//select Count(followsWho) from follows where userId=#{userId};
//	public int numFollows(int userNo);
//	//select Count(userId) from follows where followsWho=#{userId};
//	public int numFollowers(int userNo);
//	
	//select * from follows where userId=#{userId} and followsWho=#{toFollow};
	public int isfollowing(int userNo, int toFollow);
	//팔로우 버튼 상태 확인할때도 씀
	// 0 이어야 팔로우가능
	//follow
	public int insert(Follow follow);
	
//	public int update(Follow follow);// 쓸일이 없음 
	
	//unfollow
	public int delete(int followId);
}
