package com.ssafy.wwwfit.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
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

import com.ssafy.wwwfit.model.dto.Follow;
import com.ssafy.wwwfit.model.dto.User;
import com.ssafy.wwwfit.model.service.BadgesProgressService;
import com.ssafy.wwwfit.model.service.BookmarkService;
import com.ssafy.wwwfit.model.service.FollowService;
import com.ssafy.wwwfit.model.service.HavingBadgeService;
import com.ssafy.wwwfit.model.service.LikeService;
import com.ssafy.wwwfit.model.service.UserService;

@RestController
@RequestMapping("/api-user")
public class UserController {
	@Autowired
	private BookmarkService bService;
	
	@Autowired
	private LikeService lService;
	@Autowired
	private UserService uService;
	@Autowired 
	private FollowService fService;
	
	@Autowired
	private HavingBadgeService hService;
	
	@Autowired
	private BadgesProgressService bpService;
	
	//유저가 행하는 모든 일,,, 좋아요,북마크,리뷰,팔로우
	
	//일단 기본 cRUD 만 해보자!!
	
	
	//회원가입 // 유효성 확인 후 hService와 bpService에서 등록하기!
	@PostMapping("/user")
	public ResponseEntity<?> doRegist(User user){
		uService.regist(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//회원조회
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getUser(@PathVariable String userId){
		User user = uService.getUser(userId);
		if(user==null) {
			return new ResponseEntity<String>("회원을 찾을 수 없습니다",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> getUsers(){
		List<User> allUsers= uService.getUsers();
		
		return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> editUser(User user){
		///이거 로그인 유저 혹은 관리자여야 가능한 비교를 어디서 하더라??? 교수님 강의중에 admin 적용,, interceptor? prehandle?
		int result = uService.updateInfo(user);
		if(result==0) return new ResponseEntity<String>("수정불가",HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<String>("회원 정보 수정 완료",HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable String userId,String loginUser){
		//자기 자신인지/ 비밀번호 확인하고 넘어가야함 뷰!! 
		int result = uService.quit(userId);
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	
//	@GetMapping("/user/follower/{userId}")
//	public ResponseEntity<?> getFollowers(@PathVariable String userId, User loginUser){
//		List<Follow> follows= fService.getFollowers(userId);
//		List<User> followerList = new ArrayList<User>();
//		for(Follow f : follows) {
//			followerList.add(uService.getUser(f.getUserId()));
//		}
////		List<User> followerList = fService
//		return new ResponseEntity<List<User>>(followerList,HttpStatus.OK);
//	}
}
