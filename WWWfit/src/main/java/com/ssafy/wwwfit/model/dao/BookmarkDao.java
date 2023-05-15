package com.ssafy.wwwfit.model.dao;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Bookmark;

public interface BookmarkDao {
	//유저의 북마크 조회
	public List<Bookmark> selectAll(String userId);
	// 그 중 하나 조회
	public Bookmark selectOne(int bookmarkId);
	//중복확인 후 생성?
	public Bookmark insert(Bookmark Bookmark);
	
	//select * from bookmarks where userId=#{userId} and posterSeq=#{posterSeq}; 
	// 값이 0이어야 생성가능
	public int doesexist(String userId, int posterSeq);
	
	public int update(Bookmark bookmark);
	
	public int delete(int bookmarkId);
	//북마크 폴더/분류별 --> 매퍼에서 현재 본인 북마크/북마크 폴더모음
	public List<Bookmark> selectMarks(String userId,String bname);

}
