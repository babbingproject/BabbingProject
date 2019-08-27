package com.example.demo.service.review.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.review.ReviewImagevo;

@Service
public class ReviewImageServiceImpl implements ReviewImageService  {

	@Autowired
	ReviewImageRepository reviewImageRepo;
	
	@Override
	public ReviewImagevo getImgById(ReviewImagevo reviewImagevo) {
		return reviewImageRepo.findById(reviewImagevo.getImg_id()).get(); 
	}
	
	@Override
	public ReviewImagevo getReviewImagevo(ReviewImagevo reviewImagevo) {
		return reviewImageRepo.findById(reviewImagevo.getImg_id()).get();
	}
	
	public ReviewImagevo saveReviewImagevo(ReviewImagevo reviewImagevo) {
		return reviewImageRepo.save(reviewImagevo);
	}
}
