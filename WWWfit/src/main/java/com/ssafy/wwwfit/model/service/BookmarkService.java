package com.ssafy.wwwfit.model.service;

import java.util.List;

import com.ssafy.wwwfit.model.dto.Bookmark;

public interface BookmarkService {
	
	public List<Bookmark> selectAll(String userId);
	
	public Bookmark selectOne(int bookmarkId);
	//유저의 폴더 안 북마크
	public List<Bookmark> selectBmFolder(String userId,String bname);
	//유저의 북마크 폴더목록
	public List<String> bmFolders(String userId);
	
	public int update(Bookmark bookmark);
	
	public int create(Bookmark bookmark);
	
	public int delete(int bookmarkId);

}
