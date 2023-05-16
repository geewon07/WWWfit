package com.ssafy.wwwfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.wwwfit.model.dao.FollowDao;
import com.ssafy.wwwfit.model.dto.Follow;

public class FollowServiceImpl implements FollowService {

	@Autowired
	private FollowDao fDao;
	
	@Override
	public List<Follow> getFollowers(String userId) {
		List<Follow> followerList = fDao.selectFollowers(userId);
		return followerList;
		
	}

	@Override
	public List<Follow> getFollowing(String userId) {
		List<Follow> followingList = fDao.selectFollows(userId);
		return followingList;
	}

	@Override
	public int getFollowerCnt(String userId) {
		int followerCnt = fDao.selectFollowers(userId).size();
		return followerCnt;
	}

	@Override
	public int getFollowingCnt(String userId) {
		int followingCnt = fDao.selectFollows(userId).size();
		return followingCnt;
	}

	@Override
	public boolean isFollowing(String userId, String toFollow) {
		boolean alreadyFollowed = fDao.isfollowing(userId, toFollow)==0?false:true;
		return alreadyFollowed;
	}

	@Override
	public int doFollow(Follow follow) {
		int result = fDao.insert(follow);
		return result;
	}

	@Override
	public int unFollow(int followId) {
		int result = fDao.delete(followId);
		return result;
	}

}
