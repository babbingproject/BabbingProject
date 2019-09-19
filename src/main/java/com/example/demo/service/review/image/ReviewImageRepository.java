package com.example.demo.service.review.image;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.review.ReviewImagevo;

public interface ReviewImageRepository extends JpaRepository<ReviewImagevo, Integer>{
	
	@Query(value = "SELECT * FROM review_imagevo WHERE review_id = ?", nativeQuery = true)
	List<ReviewImagevo> selectReviewImgList(int reviewId);
}
