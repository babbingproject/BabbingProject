package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.review.Commentvo;
import com.example.demo.service.review.CommentService;

@RestController
public class RestCommentController {

	private static final Logger logger = LoggerFactory.getLogger(RestCommentController.class);
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "getCommentList", method = RequestMethod.POST)
	public List<Commentvo> getCommentList(@RequestParam("reviewId") int reviewId) throws Exception {
		return commentService.getCommentList(reviewId);
	}

}
