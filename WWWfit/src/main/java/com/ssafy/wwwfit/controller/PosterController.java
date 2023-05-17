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

import com.ssafy.wwwfit.model.dto.Poster;
import com.ssafy.wwwfit.model.dto.User;
import com.ssafy.wwwfit.model.service.BookmarkService;
import com.ssafy.wwwfit.model.service.LikeService;
import com.ssafy.wwwfit.model.service.PosterService;

@RestController
@RequestMapping("/api-poster")
public class PosterController { // 관리자 전용!!!!!
	
	@Autowired
	private PosterService pService;


	
	//기본 전체 조회/ 검색 통합시키는 것,,, ?
	@GetMapping("/poster")
	public ResponseEntity<?> getPosters(){
		List<Poster> pList=pService.getAll();
		
		if(pList.size()==0) {
			return new ResponseEntity<String>("없습니다",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Poster>>(pList,HttpStatus.OK);
	}
	
	@PostMapping("/poster")
	public ResponseEntity<?> postPoster(Poster poster){
		String msg="";
		int result = pService.create(poster);
		if(result!=0) {
			msg= "등록성공";
		}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/poster")
	public ResponseEntity<?> editPoster(Poster poster){
		//관리자만 가능하게!!!!
		int result  =pService.edit(poster);
		
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	@DeleteMapping("/poster/{posterId}")
	public ResponseEntity<?> delete(@PathVariable int posterId){
		int result = pService.delete(posterId);
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	
}
