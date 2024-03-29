package com.ssafy.wwwfit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.wwwfit.model.dto.SearchCondition;
import com.ssafy.wwwfit.model.dto.User;
import com.ssafy.wwwfit.model.service.BadgesProgressService;
import com.ssafy.wwwfit.model.service.HavingBadgeService;
import com.ssafy.wwwfit.model.service.UserService;
import com.ssafy.wwwfit.util.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;


@RestController
@RequestMapping("/api-user")
public class UserController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private HavingBadgeService hService;
	
	@Autowired
	private BadgesProgressService bpService;
	
	//유저가 행하는 모든 일,,, 좋아요,북마크,리뷰,팔로우--> 일어나면 유저 서비스를 불러서 엑스피증감 하게
//	@Autowired
//	private BookmarkService bService;
//	
//	@Autowired
//	private LikeService lService;
//	
//	@Autowired 
//	private FollowService fService;
	//일단 기본 cRUD 만 해보자!!
	
	
	//회원가입 // 유효성 확인 후 hService와 bpService에서 등록하기!
	
	@PostMapping("/login")
	public ResponseEntity<?> doLogin(@RequestBody HashMap<String, Object> payload){
		String userId = (String) payload.get("userId");
		String password = (String) payload.get("userpassword");
		String token = (String) payload.get("token");
		Map<String,Object> result = new HashMap<String, Object>();
		Integer userNo = uService.login(userId, password);
//		if(userNo==null) {
//			userNo=0;
//		}
		uService.updateTokenFirebase(userNo, token);
		
		System.out.println(userNo);
		Map<String, String> data = new HashMap<String, String>();
		if(userNo==null) {
			System.out.println("reached");
			data.put("auth", "false");
			try {
				result.put("login-token", jwtUtil.createToken("login-token", data));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity<Map<String,Object>>(result,HttpStatus.OK);
		}else {
			String userName  = uService.getUser(userNo).getName();
			String str = String.valueOf(userNo);
			System.out.println("!!!!!!!!!!!!!!!!"+str);
//			Map<String, String> data = new HashMap<String, String>();
			data.put("auth", "true");
			data.put("userNo", str);
			data.put("userId", userId);
			data.put("userName",userName);
			
			try {
//				result.put("login-token", jwtUtil.createToken("login-token", str,userId,userName));
				result.put("login-token", jwtUtil.createToken("login-token", data));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return new ResponseEntity<Map<String,Object>>(result,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/user")
	public ResponseEntity<?> doRegist(User user){
		user.setUserRank("Green");
		int result = uService.regist(user);
		if(result!=0) {
			bpService.registBagesProgress(user.getUserNo());
			hService.registHavingBadge(user.getUserNo());
		}
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	//회원조회
	@GetMapping("/user/{userNo}")
	public ResponseEntity<?> getUser(@PathVariable int userNo){
		User user = uService.getUser(userNo);
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
	
	@GetMapping("/user/search")
	public ResponseEntity<?> searchUsers(SearchCondition condition){
		List<User> searchresult= uService.searchUser(condition);
		
		return new ResponseEntity<List<User>>(searchresult,HttpStatus.OK);
	}
	
	@GetMapping("/mypage/{userNo}")
	public ResponseEntity<?> getMypage(@PathVariable int userNo){
		Map<String,String> mpData = new HashMap<String, String>();
		User viewed = uService.getUser(userNo);
		
		mpData.put("name",viewed.getName());
		mpData.put("img",viewed.getImg());
		mpData.put("regDate",viewed.getRegDate());
		mpData.put("userRank",viewed.getUserRank());
		mpData.put("experience",String.valueOf(viewed.getExperience()));
		mpData.put("challengedays",String.valueOf(viewed.getChallengedays()));
		
		
		return new ResponseEntity<Map<String,String>>(mpData,HttpStatus.OK);
	}
	
	
	@PutMapping("/user")
	public ResponseEntity<?> editUser(User user){
		///이거 로그인 유저 혹은 관리자여야 가능한 비교를 어디서 하더라??? 교수님 강의중에 admin 적용,, interceptor? prehandle?
		int result = uService.updateInfo(user);
		if(result==0) return new ResponseEntity<String>("수정불가",HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<String>("회원 정보 수정 완료",HttpStatus.OK);
	}
	
	//getexp 서비스 파라미터 유저id로 바꾸고, 서비스를 북마크/평점/챌린지 기록 쪽에서 콜하는 방법 고민중, vs 뷰!
	@PutMapping("/{userNo}/exp")
	public ResponseEntity<?> getExp(int userNo, int points){
		///이거 로그인 유저 혹은 관리자여야 가능한 비교를 어디서 하더라??? 교수님 강의중에 admin 적용,, interceptor? prehandle?
		int result = uService.getExp(uService.getUser(userNo),points);
		if(result==0) return new ResponseEntity<String>("수정불가",HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<String>("경험치 조정 완료",HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{userNo}")
	public ResponseEntity<?> deleteUser(@PathVariable int userNo,int loginUser){
		//자기 자신인지/ 비밀번호 확인하고 넘어가야함 뷰!! 
		int result = uService.quit(userNo);
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	@GetMapping("auth/kakao/callback")
	public ResponseEntity<?> kakaoCallback(@RequestParam String code) {
		System.out.println("카카오토큰 : "+code);
		String access_Token = uService.getKakaoAccessToken(code);
		User user = uService.createKakaoUser(access_Token);
		int having = uService.getUserId(user.getUserId());
		
		// 회원가입
		if(having == 0) {
            user.setUserRank("Green");
			uService.insert_kakao(user);
			bpService.registBagesProgress(user.getUserNo());
			hService.registHavingBadge(user.getUserNo());
		}
		
		return doLoginKakao(user);
		
	}
	
	public ResponseEntity<?> doLoginKakao(User user){
		
		Map<String,Object> result = new HashMap<String, Object>();
		Integer userNo = uService.login(user.getUserId(), user.getPassword());
		
		Map<String, String> data = new HashMap<String, String>();
		if(userNo==null) {
			data.put("auth", "false");
			try {
				result.put("login-token", jwtUtil.createToken("login-token", data));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity<Map<String,Object>>(result,HttpStatus.OK);
		}else {
			String str = String.valueOf(userNo);
			data.put("auth", "true");
			data.put("userNo", str);
			data.put("userId", user.getUserId());
			data.put("userName",user.getName());
			
			try {
				result.put("login-token", jwtUtil.createToken("login-token", data));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<Map<String,Object>>(result,HttpStatus.OK);
	}
	
	@PostMapping("/kakao_login")
	public ResponseEntity<?> kakao_logintoken(@RequestBody HashMap<String, Object> payload) throws Exception{
		String jwt_token = (String) payload.get("jwttoken");
		String token = (String) payload.get("token");
		Map<String,Object> result = new HashMap<String, Object>();
		Claims claims = jwtUtil.valid2(jwt_token);
		System.out.println(claims);
		Map<String, Object> logintoken = (Map<String, Object>) claims.get("login-token");
		int userNo = Integer.parseInt((String) logintoken.get("userNo"));
		System.out.println(userNo);
	
		uService.updateTokenFirebase(userNo, token);
		
		Map<String, String> data = new HashMap<String, String>();
		if(userNo == 0) {
			System.out.println("reached");
			data.put("auth", "false");
			try {
				result.put("login-token", jwtUtil.createToken("login-token", data));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity<Map<String,Object>>(result,HttpStatus.OK);
		}else {
			try {
//				result.put("login-token", jwtUtil.createToken("login-token", str,userId,userName));
				result.put("login-token", payload.get("jwttoken"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return new ResponseEntity<Map<String,Object>>(result,HttpStatus.OK);
	}
	
	
	

}
