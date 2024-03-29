package com.example.demo.service.review;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.AjaxReviewImagevo;
import com.example.demo.domain.review.Commentvo;
import com.example.demo.domain.review.ReviewImagevo;
import com.example.demo.domain.review.ReviewRegistrationvo;

public interface ReviewService {


//	List<Uservo> selectUservoInfo();

	List<ReviewRegistrationvo> findAll();
	List<Object[]> getKoreanTopSix();

	List<ReviewRegistrationvo> getNewestReview();

	List<Object[]> getEverythingTopSix();

	List<Object[]> getBusinessFieldOne();

	List<Object[]> getBusinessFieldTwo();

	List<Object[]> getBusinessFieldThree();

	List<Object[]> getBusinessFieldFour();

	List<Object[]> getBusinessFieldFive();

	List<Object[]> getBusinessFieldSix();

	List<Object[]> getBusinessFieldSeven();

	List<Object[]> getSearchKeyword(String searchKeyword);
//	Page<Object[]> getSearchKeyword(String searchKeyword, PageRequest pageRequest);



//	List<ReviewRegistrationvo> selectReviewList();
	
	
	
	List<ReviewRegistrationvo> selectReviewList();

//	Tuple selectReviewIdJoinUserId(Uservo Uservo, ReviewRegistrationvo reviewRegistrationvo);

	void insertReview(ReviewRegistrationvo reviewRegistrationvo);



	ReviewRegistrationvo selectReviewView(int reviewId); 
	
	List<Object> selectReviewJoinReviewAndComment(Uservo uservo, ReviewRegistrationvo reviewRegistrationvo, Commentvo commentvo);
	
	void updateReview(ReviewRegistrationvo reviewRegistrationvo);
	
	void deleteReview(int reviewId);
	
	int createReviewId();
	
	public Page<ReviewRegistrationvo> findAll(Pageable pageable);
	public List<ReviewRegistrationvo> getNewestReviewList();
	
	
	
}