package com.ssafy.wwwfit.model.dto;

public class SearchCondition {
	// 전체검색할건지,, 부분검색 할건지 일반 포털 처럼 이미지,블로그게시글 항목별로 검색결과 나눌것인지?
	private String key = "none";// 유저:이름/ 포스터:제목, 부위, 챌린지여부, 
	private String word;
	private String orderBy = "none";// 유저: 팔로워순/ 포스터: 좋아요순, 평점순, 난이도 순
	// 필터 추가 가능한지?
	private String filter = "none"; // user, poster, bookmarks
	private String orderByDir ="desc";
	public SearchCondition() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public String getOrderByDir() {
		return orderByDir;
	}
	public void setOrderByDir(String orderByDir) {
		this.orderByDir = orderByDir;
	} 
	
	
}
