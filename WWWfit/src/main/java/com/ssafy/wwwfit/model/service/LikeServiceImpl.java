package com.ssafy.wwwfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.wwwfit.model.dao.LikeDao;
import com.ssafy.wwwfit.model.dto.Like;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeDao lDao;
	
	//유저가 좋아요 한 컨텐츠 정보가 조회됨
	@Override
	public List<Like> selectAll(int userNo) {
		List<Like> userLikes = lDao.selectAll(userNo);
		return userLikes;
	}

	@Override
	public List<Like> selectOne(int posterSeq) {
		List<Like> selectedLike = lDao.selectOne(posterSeq);
		return selectedLike;
	}

	@Override
	public int numLikes(int posterSeq) {
		int likeCnt = lDao.numLikes(posterSeq);
		return likeCnt;
	}

	@Override
	public int checkLiked(int userNo, int posterSeq) {
		int likedId = lDao.alreadyliked(userNo, posterSeq);
		return likedId;
	}

	@Override
	public int doLike(Like like) {
		int result = lDao.insert(like);
		return result;
	}

	@Override
	public int unLike(int likeId) {
		int result = lDao.delete(likeId);
		return result;
	}

	@Override
	public Like selectLike(int likeId) {
		Like selected = lDao.selectLike(likeId);
		return selected;
	}

}
