package com.ssafy.wwwfit.model.service;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Poster;
import com.ssafy.wwwfit.model.dto.SearchCondition;

public interface PosterService {
	//포스터 등록
	public int create(Poster poster);
	//포스터 조회
	public Poster getOne(int posterId);
	
	//포스터 전체 조회
	public List<Poster> getAll();
	
	//포스터 검색
	public List<Poster> searchBy(SearchCondition condition);
	
	//포스터 좋아!누르면 실행될 것 1.poster addlike, 2. Like 생성,
	public int addLike(int posterId);//포스터 전체? 아이디?
	
	public int edit(Poster poster);
	
	public int delete(int posterId);
	
	
	
	

}
