package com.example.demo.service.review;

import java.util.List;

import com.example.demo.domain.review.Commentvo;

public interface CommentService {
	
	List<Commentvo> selectCommentListAllById(int reivewId);
	
	void insertComment (Commentvo commentvo);
	
}
