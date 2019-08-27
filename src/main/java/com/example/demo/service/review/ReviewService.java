package com.example.demo.service.review;

import java.util.List;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.querydsl.core.Tuple;

public interface ReviewService {

	List<Uservo> selectUservoInfo();
	
//	void insertReview(ReviewService reviewService, Model model); // 매개변수에 리뷰이미지엔티티도 추가 해줘야함

//	List<Object[]> selectUserWithReview();
	
	void insertReview(ReviewRegistrationvo reviewRegistrationvo, Uservo uservo);
	
	List<ReviewRegistrationvo> selectReviewList();
	
	Tuple selectReviewIdJoinUserId(Uservo uservo, ReviewRegistrationvo reviewRegistrationvo);
	
//	ReviewRegistrationvo selectReviewRegistrationvo(Uservo uservo, ReviewRegistrationvo reviewRegistrationvo);
	
}