package com.example.demo.service.review;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.review.Commentvo;
import com.example.demo.domain.review.ReviewRegistrationvo;

public interface CommentService {
	
	Optional<Commentvo> selectCommentListAllById(int reviewId);
	
	void insertComment (Commentvo commentvo);

	List<Commentvo> selectCommentList(ReviewRegistrationvo reviewRegistrationvo);
	
//	List<Commentvo> selectCommentList();
	
}
