package com.ssafy.wwwfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.wwwfit.model.dao.PosterDao;
import com.ssafy.wwwfit.model.dto.Poster;
import com.ssafy.wwwfit.model.dto.SearchCondition;

@Service
public class PosterServiceImpl implements PosterService {

	@Autowired
	private PosterDao pDao;
	@Override
	public int create(Poster poster) {
		int result = pDao.insert(poster);
		return result;
	}

	@Override
	public Poster getOne(int posterId) {
		Poster selectedPoster = pDao.selectOne(posterId);
		return selectedPoster;
	}

	@Override
	public List<Poster> getAll() {
		List<Poster> allPosters = pDao.selectAll();
		return allPosters;
	}

	@Override
	public List<Poster> searchBy(SearchCondition condition) {
		List<Poster> searchResult = pDao.searchBy(condition);
		return searchResult;
	}

//	@Override
//	public int addLike(int posterId) {
//		
//		int result = pDao.update(poster);
//		return 0;
//	}

	@Override
	public int edit(Poster poster) {//detail 뷰 로 포스터 정보 불러와져 있는 상태에서 수정??
		int result = pDao.update(poster);
		return result;
	}

	@Override
	public int delete(int posterId) {
		int result = pDao.delete(posterId);
		return result;
	}

}
