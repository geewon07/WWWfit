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
import com.ssafy.wwwfit.model.dto.Follow;
import com.ssafy.wwwfit.model.service.FollowService;

@RestController
@RequestMapping("/api-follow")
public class FollowController {
	
	@Autowired
	private FollowService fService;
	
	@GetMapping("/{userId}/followers")
	public ResponseEntity<?> getFollowers(@PathVariable String userId){
		List<Follow> followers =fService.getFollowers(userId);
		return new ResponseEntity<List<Follow>>(followers,HttpStatus.OK);
	}
	
	@GetMapping("/{userId}/following")
	public ResponseEntity<?> getFollowing(@PathVariable String userId){
		List<Follow> followers =fService.getFollowing(userId);
		return new ResponseEntity<List<Follow>>(followers,HttpStatus.OK);
	}
	@GetMapping("/bookmark/{bookmarkId}")
	public ResponseEntity<?> getBookmark(@PathVariable int bookmarkId){
		Bookmark bookmark = bService.selectOne(bookmarkId);
		return new ResponseEntity<Bookmark>(bookmark,HttpStatus.OK);
	}
	
	@GetMapping("/{userId}/folder/{bname}")
	public ResponseEntity<?> getUserFolder(@PathVariable String userId,@PathVariable String bname){
		List<Bookmark> bookmarkfolder= bService.selectBmFolder(userId, bname);
		
		return new ResponseEntity<List<Bookmark>>(bookmarkfolder,HttpStatus.OK);
	}
	
	@GetMapping("/bookmark/folders")
	public ResponseEntity<?> getUserFolders (String userId){
		List<String> folders = bService.bmFolders(userId);
		
		return new ResponseEntity<List<String>>(folders,HttpStatus.OK);
	}
	
	@PostMapping("/bookmark")
	public ResponseEntity<?> createBookmark(Bookmark bookmark){
		int result = bService.create(bookmark);
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
		
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}

}
