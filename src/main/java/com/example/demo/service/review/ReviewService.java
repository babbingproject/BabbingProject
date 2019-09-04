package com.example.demo.service.review;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.querydsl.core.Tuple;

public interface ReviewService {


//	List<Uservo> selectUservoInfo();


	List<Object[]> getKoreanTopSix();

	List<Object[]> getNewestReview();

	List<Object[]> getEverythingTopSix();

	List<Object[]> getBusinessFieldOne();

	List<Object[]> getBusinessFieldTwo();

	List<Object[]> getBusinessFieldThree();

	List<Object[]> getBusinessFieldFour();

	List<Object[]> getBusinessFieldFive();

	List<Object[]> getBusinessFieldSix();

	List<Object[]> getBusinessFieldSeven();

	List<Object[]> getSearchKeyword(String searchKeyword);



	List<ReviewRegistrationvo> selectReviewList();
	
	List<ReviewRegistrationvo> selectReviewList(ReviewRegistrationvo reviewRegistrationvo);

//	Tuple selectReviewIdJoinUserId(Uservo Uservo, ReviewRegistrationvo reviewRegistrationvo);

	void insertReview(ReviewRegistrationvo reviewRegistrationvo);



	public ReviewRegistrationvo getReviewView(ReviewRegistrationvo reviewRegistrationvo); 
	
	Object selectReviewJoinUserNickName(Uservo uservo, ReviewRegistrationvo reviewRegistrationvo);
	
	void updateReview(ReviewRegistrationvo reviewRegistrationvo);
	
	void deleteReview(ReviewRegistrationvo reviewRegistrationvo);
	
}