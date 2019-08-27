package com.example.demo.service.review;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService     {
	@Autowired
	ReviewRepository reviewRepo;
	
	@Override
	public List<Object[]> getKoreanTopSix(){
		return reviewRepo.getKoreanFoodTopSix();
	}
	
	@Override
	public List<Object[]> getNewestReview(){
		return reviewRepo.getNewestReview();
	}
	
	@Override
	public List<Object[]> getEverythingTopSix(){
		return reviewRepo.getEverything();
	}
	
	@Override
	public List<Object[]> getBusinessFieldOne() {
		return reviewRepo.getBusinessFieldOne();
	}
	
	@Override
	public List<Object[]> getBusinessFieldTwo() {
		return reviewRepo.getBusinessFieldTwo();
	}
	
	@Override
	public List<Object[]> getBusinessFieldThree() {
		return reviewRepo.getBusinessFieldThree();
	}
	
	@Override
	public List<Object[]> getBusinessFieldFour() {
		return reviewRepo.getBusinessFieldFour();
	}
	
	@Override
	public List<Object[]> getBusinessFieldFive() {
		return reviewRepo.getBusinessFieldFive();
	}
	
	@Override
	public List<Object[]> getBusinessFieldSix() {
		return reviewRepo.getBusinessFieldSix();
	}
	
	@Override
	public List<Object[]> getBusinessFieldSeven() {
		return reviewRepo.getBusinessFieldSeven();
	}
	
	@Override
	public List<Object[]> getSearchKeyword(@Param("searchKeyword") String searchKeyword) {
		return reviewRepo.getSearchKeyword(searchKeyword);
	}
}
