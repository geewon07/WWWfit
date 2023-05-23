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

import com.ssafy.wwwfit.model.dto.Rating;
import com.ssafy.wwwfit.model.service.RatingService;
import com.ssafy.wwwfit.model.service.UserService;

@RestController
@RequestMapping("/api-rating")
public class RatingController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private RatingService rService;
	
	@GetMapping("/rating/{contentSeq}")
	public ResponseEntity<?> contentRating(int contentSeq){
		List<Rating> ratings = rService.selectAll(contentSeq);
		return new ResponseEntity<List<Rating>>(ratings,HttpStatus.OK);
	}
	
	@GetMapping("/one/{ratingId}")
	public ResponseEntity<?> getRating(@PathVariable int ratingId){
		Rating rating = rService.selectOne(ratingId);
		return new ResponseEntity<Rating>(rating,HttpStatus.OK);
	}
	
	//굳이 여기서 해줄까 싶기도 한데,,
	@GetMapping("/rating")
	public ResponseEntity<?> contentAVG(Integer contentSeq){
		Double avg = rService.getAVG(contentSeq);
		return new ResponseEntity<Double>(avg,HttpStatus.OK);
	}
	
	
	@PostMapping("/rating")
	public ResponseEntity<?> doRate(Rating rating){
		int result = rService.insert(rating);
		if(result!=0) {
			uService.getExp(uService.getUser(rating.getUserNo()), 5);
		}
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	
	@PutMapping("/rating")
	public ResponseEntity<?> edit(Rating rating ){
		int result = rService.update(rating);
		
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	@DeleteMapping("/rating/{ratingId}")
	public ResponseEntity<?> deleteRating(@PathVariable int ratingId){
		int result = rService.delete(ratingId);
		if(result!=0) {
			uService.getExp(uService.getUser(rService.selectOne(ratingId).getUserNo()), -5);
		}
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	

}
