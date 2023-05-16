package com.ssafy.wwwfit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.wwwfit.model.dao.BookmarkDao;
import com.ssafy.wwwfit.model.dto.Bookmark;

@Service
public class BookmarkServiceImpl implements BookmarkService {

	@Autowired
	private BookmarkDao bmDao;
	@Override
	public List<Bookmark> selectAll(String userId) {
		List<Bookmark> userBookmarks = bmDao.selectAll(userId);
		return userBookmarks;
	}

	@Override
	public Bookmark selectOne(int bookmarkId) {
		Bookmark selected = bmDao.selectOne(bookmarkId);
		return selected;
	}

	@Override
	public List<Bookmark> selectBmFolder(String userId, String bname) {
		List<Bookmark> selectedFolder = bmDao.selectMarks(userId, bname);
		return selectedFolder;
	}

	@Override
	public List<String> bmFolders(String userId) {
		List<String> userBmFolders = bmDao.folders(userId);
		return userBmFolders;
	}

	@Override
	public int update(Bookmark bookmark) {
		int result = bmDao.update(bookmark);
		return result;
	}

	@Override
	public int create(Bookmark bookmark) {
		int result = bmDao.insert(bookmark);
		return result;
	}

	@Override
	public int delete(int bookmarkId) {
		int result =bmDao.delete(bookmarkId);
		return result;
	}

}
