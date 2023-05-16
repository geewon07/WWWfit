package com.ssafy.wwwfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.wwwfit.model.dao.RatingDao;
import com.ssafy.wwwfit.model.dto.Rating;

public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingDao rDao;
	@Override
	public List<Rating> selectAll(int contentSeq) {
		List<Rating> contentRating = rDao.selectAll(contentSeq);
		return contentRating;
	}

	@Override
	public Rating selectOne(int ratingId) {
		Rating selectedRating = rDao.selectOne(ratingId);
		return selectedRating;
	}

	@Override
	public boolean isRated(String userId, int contentSeq) {
		boolean exists = rDao.isRated(userId, contentSeq)==0? false: true;
		return exists;
	}

	@Override
	public int insert(Rating rating) {
		int result= rDao.insert(rating);
		return result;
	}

	@Override
	public int update(Rating rating) {
		int result = rDao.update(rating);
		return result;
	}

	@Override
	public int delete(int ratingId) {
		int result = rDao.delete(ratingId);
		return result;
	}

}
