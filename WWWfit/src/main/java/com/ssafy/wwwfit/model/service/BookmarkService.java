package com.ssafy.wwwfit.model.service;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Bookmark;

public interface BookmarkService {
	
	public List<Bookmark> selectAll(int userNo);
	
	public Bookmark selectOne(int bookmarkId);
	//유저의 폴더 안 북마크
	public List<Bookmark> selectBmFolder(int userNo,String bname);
	//유저의 북마크 폴더목록
	public List<String> bmFolders(int userNo);
	
	public int update(Bookmark bookmark);
	
	public int create(Bookmark bookmark);
	
	public int delete(int bookmarkId);

}
