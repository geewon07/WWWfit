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

import com.ssafy.wwwfit.model.dto.Follow;
import com.ssafy.wwwfit.model.service.FollowService;
import com.ssafy.wwwfit.model.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/api_follow")
public class FollowController {
	
	@Autowired
	private UserService uService;
	@Autowired
	private FollowService followService;
	
	@GetMapping("/follower/{userNo}")
	public ResponseEntity<?> getFollowers(@PathVariable int userNo) {
	    List<Follow> followers = followService.getFollowers(userNo);
	    
	    if (followers.isEmpty() | followers == null ) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("팔로우가 없습니다.");
	    } else {
	        return ResponseEntity.ok(followers);
	    }
	}
	
	@GetMapping("/following/{userNo}")
	public ResponseEntity<?> getFollowing(@PathVariable int userNo) {
	    List<Follow> following = followService.getFollowing(userNo);
	    
	    if (following.isEmpty() | following == null ) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("팔로잉이 없습니다.");
	    } else {
	        return ResponseEntity.ok(following);
	    }
	}
	
	//팔로워수 
	@GetMapping("/followercount/{userNo}")
	public ResponseEntity<?> Followercount(@PathVariable int userNo) {
	    int followers = followService.getFollowerCnt(userNo);
	    
	    if (followers == 0) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("팔로우가 없습니다.");
	    } else {
	        return ResponseEntity.ok(followers);
	    }
	}
	
	//팔로잉수
	@GetMapping("/followingcount/{userNo}")
	public ResponseEntity<?> Following_count(@PathVariable int userNo) {
		int following = followService.getFollowingCnt(userNo);
	    
	    if (following == 0 ) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("팔로잉이 없습니다.");
	    } else {
	        return ResponseEntity.ok(following);
	    }
	}
	// Map으로 받을까?
	@GetMapping("/isfollowing") // 이게 맞는지...?
	public ResponseEntity<String> isFollowing( int userNo, int toFollow) {
	    boolean alreadyFollowed = followService.isFollowing(userNo, toFollow);
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
		
		if(followService.isFollowing(follow.getUserNo(), follow.getFollowsWho())) {
			
			result="already following";
			return new ResponseEntity<String>(result, HttpStatus.BAD_REQUEST);
		}
		int insertResult = followService.doFollow(follow);
			if (insertResult == 1) {
				result = "success";
				status = HttpStatus.OK;
				uService.getExp(uService.getUser(follow.getUserNo()), 1);
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
				uService.getExp(uService.getUser(followService.selectFollow(followId).getUserNo()), -11);
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
