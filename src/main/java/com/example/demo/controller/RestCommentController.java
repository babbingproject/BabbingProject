package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value = "getCommentList", method = RequestMethod.GET)
	public List<Commentvo> getCommentList(@RequestParam("reviewId") int reviewId) throws Exception {
		System.out.println(reviewId);
		return commentService.getCommentList(reviewId);
	}
	@RequestMapping(value = "saveComment", method = RequestMethod.POST)
	public Map<String, Object> addComment(@RequestBody Commentvo commentvo) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			commentService.saveComment(commentvo);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		return result;
		
	}

}
