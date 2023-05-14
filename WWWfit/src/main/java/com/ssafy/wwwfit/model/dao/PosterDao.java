package com.ssafy.wwwfit.model.dao;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Poster;
import com.ssafy.wwwfit.model.dto.SearchCondition;

public interface PosterDao {
	//전체 조회
	public List<Poster> selectAll();
	//
	public List<Poster> searchBy(SearchCondition condition);
	
	public Poster selectOne(int posterId);
	
	//중복검사?
	//포스터이지 게시물이 아님,, 컨텐츠 제공은 내가함,,,
	public int insert(Poster poster);
	// 수정시 selectone 불러서 가져옴?
	public int update(Poster poster);
	
	public int delete(int posterId);

}
