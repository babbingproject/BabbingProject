package com.example.demo.service.review.image;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.review.AjaxReviewImagevo;

public interface AjaxReviewImageRepository extends JpaRepository<AjaxReviewImagevo, Integer> {
	
	@Query(value = "SELECT ajax_review_img FROM ajax_review_imagevo WHERE review_id = ?", nativeQuery = true)
	List<AjaxReviewImagevo> getAjaxReviewImg(int reviewId);

	@Query(value = "SELECT * FROM ajax_review_imagevo WHERE review_id = ?", nativeQuery = true)
	List<AjaxReviewImagevo> getReviewImg(int reviewId);
	
	@Query(value="DELETE FROM ajax_review_imagevo WHERE ajax_review_img LIKE %?%", nativeQuery = true)
	void deleteAjaxReviewImg(String ajaxReviewImage);
	
}
