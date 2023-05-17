package com.ssafy.wwwfit.model.dao;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Bookmark;

public interface BookmarkDao {
	//유저의 북마크 조회
	public List<Bookmark> selectAll(int userNo);
	// 그 중 하나 조회
	public Bookmark selectOne(int bookmarkId);
	//북마크 폴더/분류별 --> 매퍼에서 현재 본인 북마크/북마크 폴더모음

	public List<Bookmark> selectMarks(int userNo,String bname);
	//select * from bookmarks where userId=#{userId} and posterSeq=#{posterSeq};
	public List<String> folders(int userNo);
	
	//폴더 변경/공개변경
	public int update(Bookmark bookmark);

// 값이 0이어야 생성가능?? 중복으로 가능하지 않을까?
//	public int doesexist(int userNo, int posterSeq);
	
	//중복확인 후 생성?
	public int insert(Bookmark bookmark);
	
	public int delete(int bookmarkId);
	
}
