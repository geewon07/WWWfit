package com.ssafy.wwwfit.model.service;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Like;

public interface LikeService {
	
	public List<Like> selectAll(int userNo);
	
	public List<Like> selectOne(int posterSeq);
	
	public Like selectLike(int likeId);
	
	public int numLikes(int posterSeq);
	
	public boolean checkLiked(int userNo, int posterSeq);
	
	public int doLike(Like like);
	
	public int unLike(int likeId);

}
