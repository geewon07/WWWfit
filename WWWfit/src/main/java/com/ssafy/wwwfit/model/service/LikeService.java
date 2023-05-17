package com.ssafy.wwwfit.model.service;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Like;

public interface LikeService {
	
	public List<Like> selectAll(String userId);
	
	public List<Like> selectOne(int posterSeq);
	
	public int numLikes(int posterSeq);
	
	public boolean checkLiked(String userId, int posterSeq);
	
	public int doLike(Like like);
	
	public int unLike(int likeId);

}