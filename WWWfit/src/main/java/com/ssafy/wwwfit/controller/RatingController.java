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

@RestController
@RequestMapping("/api-rating")
public class RatingController {
	
	@Autowired
	private RatingService rService;
	
	@GetMapping("/rating/{contentSeq}")
	public ResponseEntity<?> contentRating(int contentSeq){
		List<Rating> ratings = rService.selectAll(contentSeq);
		return new ResponseEntity<List<Rating>>(ratings,HttpStatus.OK);
	}
	
	@GetMapping("/rating/{ratingId}")
	public ResponseEntity<?> getBookmark (@PathVariable int ratingId){
		Rating rating = rService.selectOne(ratingId);
		return new ResponseEntity<Rating>(rating,HttpStatus.OK);
	}
	
	@PostMapping("/rating")
	public ResponseEntity<?> doRate(Rating rating){
		int result = rService.insert(rating);
		
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
		
		return new ResponseEntity<Integer>(result,HttpStatus.OK);
	}
	

}
