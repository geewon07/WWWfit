package com.ssafy.wwwfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.wwwfit.model.dao.RatingDao;
import com.ssafy.wwwfit.model.dto.Rating;

@Service
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
	public boolean isRated(int userNo, int contentSeq) {
		boolean exists = rDao.isRated(userNo, contentSeq)==0? false: true;
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

	@Override
	public double getAVG(int contentSeq) {
		double result = rDao.getAVG(contentSeq);
		return result;
	}

}
