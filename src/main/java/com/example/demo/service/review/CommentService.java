package com.example.demo.service.review;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.review.Commentvo;
import com.example.demo.domain.review.ReviewRegistrationvo;

public interface CommentService {
	
	void insertComment (Commentvo commentvo);

	List<Commentvo> selectCommentList(ReviewRegistrationvo reviewRegistrationvo);
	
	void deleteComment(int commentId);
	
	public List<Commentvo> getCommentList(int commentId) throws Exception;
	
}
