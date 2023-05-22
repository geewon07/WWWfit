package com.ssafy.wwwfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.wwwfit.model.dto.Like;
import com.ssafy.wwwfit.model.dto.Poster;
import com.ssafy.wwwfit.model.service.LikeService;
import com.ssafy.wwwfit.model.service.PosterService;
import com.ssafy.wwwfit.model.service.UserService;

@RestController
@RequestMapping("/api-like")
public class LikeController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private PosterService pService;
	@Autowired
	private LikeService lService;
	
	//해당 포스터의 좋아요 조회
	@GetMapping("/like/{posterSeq}")
	public ResponseEntity<?> getPosterLikes(@PathVariable int posterSeq){
		List<Like> likes = lService.selectOne(posterSeq);
		return new ResponseEntity<List<Like>>(likes, HttpStatus.OK);
	}
	//해당 유저의 좋아요 조회
	@GetMapping("/user/{userNo}")
	public ResponseEntity<?> getUserLikes(@PathVariable int userNo){
		List<Like> likes = lService.selectAll(userNo);
		return new ResponseEntity<List<Like>>(likes, HttpStatus.OK);
	}
	
//	@GetMapping("/like")
//	public ResponseEntity<?> likeCheck(int loginUser, int posterSeq){
//		if(lService.checkLiked(loginUser, posterSeq)) {
//			return new ResponseEntity<String>("이미 좋아요를 누른 ",HttpStatus.OK);
//		}else
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	@PostMapping("/like")
	public ResponseEntity<?> doLike(int loginUser, int posterSeq){

		int result = lService.doLike(new Like(posterSeq,loginUser));
		if(result!=0) {
			Poster selected = pService.getOne(posterSeq);
			selected.setLikeCount(selected.getLikeCount()+1);
			pService.edit(selected);
			uService.getExp(uService.getUser(loginUser), 1);
		}
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/like")
	public ResponseEntity<?> unLike(int userNo, int posterSeq){
		int likeId =lService.checkLiked(userNo, posterSeq);
		int result = lService.unLike(likeId);
		Poster selected = pService.getOne(posterSeq);
		selected.setLikeCount(selected.getLikeCount()-1);
		pService.edit(selected);
		if(result!=0) {
			uService.getExp(uService.getUser(lService.selectLike(likeId).getUserNo()), -1);
		}
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
}
