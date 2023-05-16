package com.ssafy.wwwfit.controller;

import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.wwwfit.model.dto.Follow;
import com.ssafy.wwwfit.model.service.FollowService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api_follow")
public class FollowController {
	
	@Autowired
	private FollowService followService;
	
	@GetMapping("/follower/{userId}")
	public ResponseEntity<?> getFollowers(@PathVariable String userId) {
	    List<Follow> followers = followService.getFollowers(userId);
	    
	    if (followers.isEmpty() | followers == null ) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("팔로우가 없습니다.");
	    } else {
	        return ResponseEntity.ok(followers);
	    }
	}
	
	@GetMapping("/Following/{userId}")
	public ResponseEntity<?> getFollowing(@PathVariable String userId) {
	    List<Follow> following = followService.getFollowing(userId);
	    
	    if (following.isEmpty() | following == null ) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("팔로잉이 없습니다.");
	    } else {
	        return ResponseEntity.ok(following);
	    }
	}
	
	//팔로워수 
	@GetMapping("/follower_count/{userId}")
	public ResponseEntity<?> Followercount(@PathVariable String userId) {
	    int followers = followService.getFollowerCnt(userId);
	    
	    if (followers == 0) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("팔로우가 없습니다.");
	    } else {
	        return ResponseEntity.ok(followers);
	    }
	}
	
	//팔로잉수
	@GetMapping("/Following_count/{userId}")
	public ResponseEntity<?> Following_count(@PathVariable String userId) {
		int following = followService.getFollowingCnt(userId);
	    
	    if (following == 0 ) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("팔로잉이 없습니다.");
	    } else {
	        return ResponseEntity.ok(following);
	    }
	}
	
	@GetMapping("/Following_count/{userId}")
	public ResponseEntity<?> isFollowing(@PathVariable String userId) {
		int following = followService.getFollowingCnt(userId);
	    
	    if (following == 0 ) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("팔로잉이 없습니다.");
	    } else {
	        return ResponseEntity.ok(following);
	    }
	}
	
	@GetMapping("/api_follow/is-following/{userId}/{toFollow}") // 이게 맞는지...?
	public ResponseEntity<String> isFollowing(@PathVariable String userId, @PathVariable String toFollow) {
	    boolean alreadyFollowed = followService.isFollowing(userId, toFollow);
	    if (alreadyFollowed) {
	        return new ResponseEntity<>("Already following", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Not following", HttpStatus.OK);
	    }
	}
	
	// @PreAuthorize("isAuthenticated()")
	@PostMapping("")
	public ResponseEntity<String> doFollow(@RequestBody Follow follow) {
		String result = null;
		HttpStatus status = null;
		int insertResult = followService.doFollow(follow);
			if (insertResult == 1) {
				result = "success";
				status = HttpStatus.OK;
			} else {
				result = "fail";
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		return new ResponseEntity<String>(result, status);
	}
	
	// @PreAuthorize("isAuthenticated()") 이걸 사용하면 사용자가 맞는지 확인 가능 spring security이긴 함!
	@DeleteMapping("/{followId}")
	public ResponseEntity<String> unFollow(@PathVariable int followId) {
		String result = null;
		HttpStatus status = null;
		try {
			int deleteResult = followService.unFollow(followId);
			if (deleteResult == 1) {
				result = "success";
				status = HttpStatus.OK;
			} else {
				result = "fail";
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(result, status);
	}
}
