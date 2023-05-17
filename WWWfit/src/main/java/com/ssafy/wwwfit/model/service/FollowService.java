package com.ssafy.wwwfit.model.service;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Follow;

public interface FollowService {
	
	public List<Follow> getFollowers(int userNo);
	
	public List<Follow> getFollowing(int userNo);
	
	// selecfollows/ers 활용해서 cnt값 반환
	public int getFollowerCnt(int userNo);
	
	public int getFollowingCnt(int userNo);
	
	public boolean isFollowing(int userNo,int toFollow);
	
	public int doFollow(Follow follow);
	
	public int unFollow(int followId);
}
