package com.example.demo.service.review;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.Commentvo;
import com.example.demo.domain.review.ReviewRegistrationvo;

public interface ReviewService {


//	List<Uservo> selectUservoInfo();

	List<ReviewRegistrationvo> findAll();
	List<Object[]> getKoreanTopSix();

	List<ReviewRegistrationvo> getNewestReview();

	List<ReviewRegistrationvo> getEverythingTopSix();

	List<ReviewRegistrationvo> getBusinessFieldOne();

	List<ReviewRegistrationvo> getBusinessFieldTwo();

	List<ReviewRegistrationvo> getBusinessFieldThree();

	List<ReviewRegistrationvo> getBusinessFieldFour();

	List<ReviewRegistrationvo> getBusinessFieldFive();

	List<ReviewRegistrationvo> getBusinessFieldSix();

	List<ReviewRegistrationvo> getBusinessFieldSeven();

	List<Object[]> getSearchKeyword(String searchKeyword);
//	Page<Object[]> getSearchKeyword(String searchKeyword, PageRequest pageRequest);



	List<ReviewRegistrationvo> selectReviewList();
	
	List<ReviewRegistrationvo> selectReviewList(ReviewRegistrationvo reviewRegistrationvo);

//	Tuple selectReviewIdJoinUserId(Uservo Uservo, ReviewRegistrationvo reviewRegistrationvo);

	void insertReview(ReviewRegistrationvo reviewRegistrationvo);



	public ReviewRegistrationvo selectReviewView(ReviewRegistrationvo registrationvo); 
	
	List<Object> selectReviewJoinReviewAndComment(Uservo uservo, ReviewRegistrationvo reviewRegistrationvo, Commentvo commentvo);
	
	void updateReview(ReviewRegistrationvo reviewRegistrationvo);
	
	void deleteReview(ReviewRegistrationvo reviewRegistrationvo);
	
	public Page<ReviewRegistrationvo> findAll(Pageable pageable);
	public List<ReviewRegistrationvo> getNewestReviewList();
}