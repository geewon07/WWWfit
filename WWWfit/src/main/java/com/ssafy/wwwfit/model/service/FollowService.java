package com.ssafy.wwwfit.model.service;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Follow;

public interface FollowService {
	
	public List<Follow> getFollowers(String userId);
	
	public List<Follow> getFollowing(String userId);
	
	public int getFollowerCnt(String userId);
	
	public int getFollowingCnt(String userId);
	
	public boolean isFollowing(String userId,String toFollow);
	
	public int doFollow(Follow follow);
	
	public int unFollow(int followId);
}
