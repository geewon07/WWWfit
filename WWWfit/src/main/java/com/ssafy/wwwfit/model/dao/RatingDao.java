package com.ssafy.wwwfit.model.dao;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Rating;

public interface RatingDao {

	public List<Rating> selectAll(int contentSeq);//
	
	//select AVG(score) from ratings where contentSeq = #{contentSeq};
	public int getAVG(int contentSeq);
	
	public Rating selectOne(int ratingId);
	
	public int isRated(String userId, int contentSeq);
	//중복검사
	public int insert(Rating rating);
	
	public int update(Rating rating);
	
	public int delete(int ratingId);
	
	
	//search option?
	
}
