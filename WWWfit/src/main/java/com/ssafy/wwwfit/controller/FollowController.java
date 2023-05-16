package com.ssafy.wwwfit.controller;

import java.util.ArrayList;
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
import com.ssafy.wwwfit.model.dto.User;
import com.ssafy.wwwfit.model.service.FollowService;
import com.ssafy.wwwfit.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-follow")
public class FollowController {
	
	@Autowired
	private FollowService fService;
	@Autowired
	private UserService uService;
	
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
	@ApiOperation("returns user list")
	@GetMapping("/followers")//
	public ResponseEntity<?> getFollowersList(String userId){
		List<Follow> follows= fService.getFollowers(userId);
		List<User> followerList = new ArrayList<User>();
		for(Follow f : follows) {
			followerList.add(uService.getUser(f.getUserId()));
		}
		return new ResponseEntity<List<User>>(followerList,HttpStatus.OK);
	}
	@GetMapping("/following")
	public ResponseEntity<?> getFollowingList(String userId){
		List<Follow> follows= fService.getFollowing(userId);
		List<User> followingList = new ArrayList<User>();
		for(Follow f : follows) {
			followingList.add(uService.getUser(f.getUserId()));
		}
		return new ResponseEntity<List<User>>(followingList,HttpStatus.OK);
	}
	@PostMapping("/follow")
	public ResponseEntity<?> doFollow(Follow follow){
		if(fService.isFollowing(follow.getUserId(),follow.getFollowsWho())) {
			//toggle??해야할까??
			return new ResponseEntity<String>("이미 팔로우중인 유저입니다",HttpStatus.BAD_REQUEST);
		}
		int result = fService.doFollow(follow);
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	@DeleteMapping("/unfollow")
	public ResponseEntity<?> delete(int followId){
		int result = fService.unFollow(followId);
		
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}

}
