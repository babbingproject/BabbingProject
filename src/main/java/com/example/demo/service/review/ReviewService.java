package com.example.demo.service.review;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ReviewService {

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

	List<Object[]> getSearchKeyword(@Param("searchKeyword") String searchKeyword);

}