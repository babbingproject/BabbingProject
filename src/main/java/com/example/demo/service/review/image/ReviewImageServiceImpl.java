package com.example.demo.service.review.image;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.review.AjaxReviewImagevo;
import com.example.demo.domain.review.ReviewImagevo;

@Service
public class ReviewImageServiceImpl implements ReviewImageService  {

	@Autowired
	ReviewImageRepository reviewImageRepo;
	
	@Autowired
	AjaxReviewImageRepository ajaxReviewImageRepo;
	
	
	@Override
	public ReviewImagevo getImgById(ReviewImagevo reviewImagevo) {
		return reviewImageRepo.findById(reviewImagevo.getImgId()).get(); 
	}
	
	@Override
	public ReviewImagevo getReviewImagevo(ReviewImagevo reviewImagevo) {
		return reviewImageRepo.findById(reviewImagevo.getImgId()).get();
	}
	
	public ReviewImagevo saveReviewImagevo(ReviewImagevo reviewImagevo) {
		return reviewImageRepo.save(reviewImagevo);

	}

	@Override
	public void insertReviewImg(ReviewImagevo reviewImagevo) {
		reviewImageRepo.save(reviewImagevo);
		
	}
	@Override
	public List<AjaxReviewImagevo> selectAjaxReviewImgList(int reviewId) {
		
		
		return ajaxReviewImageRepo.getReviewImg(reviewId);
		
	}

	@Override
	public void deleteajaxReviewImg(String ajaxReviewImage) {
		ajaxReviewImageRepo.deleteAjaxReviewImg(ajaxReviewImage);
	}

	@Override
	public void ajaxReviewImgUpdate(AjaxReviewImagevo ajaxReviewImagevo) {
		
		ajaxReviewImageRepo.save(ajaxReviewImagevo);
	}
}
