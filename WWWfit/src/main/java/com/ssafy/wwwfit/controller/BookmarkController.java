package com.ssafy.wwwfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.wwwfit.model.dto.Bookmark;
import com.ssafy.wwwfit.model.service.BookmarkService;
import com.ssafy.wwwfit.model.service.UserService;

@RestController
@RequestMapping("/api-bookmark")
public class BookmarkController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private BookmarkService bService;
	
	@GetMapping("/{userNo}")
	public ResponseEntity<?> getUserBookmark(@PathVariable int userNo){
		List<Bookmark> userBookmark =bService.selectAll(userNo);
		return new ResponseEntity<List<Bookmark>>(userBookmark,HttpStatus.OK);
	}
	@GetMapping("/bookmark/{bookmarkId}")
	public ResponseEntity<?> getBookmark(@PathVariable int bookmarkId){
		Bookmark bookmark = bService.selectOne(bookmarkId);
		return new ResponseEntity<Bookmark>(bookmark,HttpStatus.OK);
	}
	
	@GetMapping("/{userNo}/folder/{bname}")
	public ResponseEntity<?> getUserFolder(@PathVariable int userNo,@PathVariable String bname){
		List<Bookmark> bookmarkfolder= bService.selectBmFolder(userNo, bname);
		
		return new ResponseEntity<List<Bookmark>>(bookmarkfolder,HttpStatus.OK);
	}
	
	@GetMapping("/bookmark/folders")
	public ResponseEntity<?> getUserFolders (int userNo){
		List<String> folders = bService.bmFolders(userNo);
		
		return new ResponseEntity<List<String>>(folders,HttpStatus.OK);
	}
	
	@PostMapping("/bookmark")
	public ResponseEntity<?> createBookmark(Bookmark bookmark){
		int result = bService.create(bookmark);
		if(result !=0) {
			uService.getExp(uService.getUser(bookmark.getUserNo()), 2);
		}
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	@PutMapping("/bookmark")
	public ResponseEntity<?> edit(Bookmark bookmark){
		int result= bService.update(bookmark);
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	@DeleteMapping("/bookmark/{bookmarkId}")
	public ResponseEntity<?> delete(@PathVariable int bookmarkId){
		int result = bService.delete(bookmarkId);
		if(result!=0) {
			uService.getExp(uService.getUser(bService.selectOne(bookmarkId).getUserNo()), -2);
		}
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	
	

}
