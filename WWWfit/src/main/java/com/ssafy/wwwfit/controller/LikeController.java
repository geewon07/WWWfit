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

import com.ssafy.wwwfit.model.dto.Like;
import com.ssafy.wwwfit.model.service.LikeService;

@RestController
@RequestMapping("/api-like")
public class LikeController {
	
	@Autowired
	private LikeService lService;
	
	//해당 포스터의 좋아요 조회
	@GetMapping("/like/{posterSeq}")
	public ResponseEntity<?> getPosterLikes(@PathVariable int posterSeq){
		List<Like> likes = lService.selectOne(posterSeq);
		return new ResponseEntity<List<Like>>(likes, HttpStatus.OK);
	}
	//해당 유저의 좋아요 조회
	@GetMapping("/like/{userId}")
	public ResponseEntity<?> getUserLikes(@PathVariable String userId){
		List<Like> likes = lService.selectAll(userId);
		return new ResponseEntity<List<Like>>(likes, HttpStatus.OK);
	}
	
	@GetMapping("/like")
	public ResponseEntity<?> likeCheck(String loginUser, int posterSeq){
		if(lService.checkLiked(loginUser, posterSeq)) {
			return new ResponseEntity<String>("이미 좋아요를 누른 ",HttpStatus.OK);
		}else
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/like")
	public ResponseEntity<?> doLike(String loginUser, int posterSeq){

		int result = lService.doLike(new Like(posterSeq,loginUser));
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/like/{likeId}")
	public ResponseEntity<?> unLike(@PathVariable int likeId){
		int result = lService.unLike(likeId);
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
}
