package com.ssafy.wwwfit.model.service;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Rating;

public interface RatingService {
	
	public List<Rating> selectAll(int contentSeq);
	
	public Rating selectOne(int ratingId);
	
	public Double getAVG(Integer contentSeq);
	
	public boolean isRated(int userNo, int contentSeq);
	
	public int insert(Rating rating);
	
	public int update(Rating rating);
	
	public int delete(int ratingId);

}
