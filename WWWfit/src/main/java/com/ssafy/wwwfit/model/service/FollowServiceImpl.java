package com.ssafy.wwwfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.wwwfit.model.dao.FollowDao;
import com.ssafy.wwwfit.model.dto.Follow;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	private FollowDao fDao;
	
	@Override
	public List<Follow> getFollowers(int userNo) {
		List<Follow> followerList = fDao.selectFollowers(userNo);
		return followerList;
		
	}

	@Override
	public List<Follow> getFollowing(int userNo) {
		List<Follow> followingList = fDao.selectFollows(userNo);
		return followingList;
	}

	@Override
	public int getFollowerCnt(int userNo) {
		int followerCnt = fDao.selectFollowers(userNo).size();
		return followerCnt;
	}

	@Override
	public int getFollowingCnt(int userNo) {
		int followingCnt = fDao.selectFollows(userNo).size();
		return followingCnt;
	}

	@Override
	public boolean isFollowing(int userNo, int toFollow) {
		boolean alreadyFollowed = fDao.isfollowing(userNo, toFollow)==0?false:true;
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

	@Override
	public Follow selectFollow(int followId) {
		Follow selected = fDao.selectOne(followId);
		return selected;
	}

}
