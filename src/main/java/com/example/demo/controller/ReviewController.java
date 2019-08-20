package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.review.ReviewImagevo;
import com.example.demo.service.review.ReviewService;
import com.example.demo.service.review.image.ReviewImageService;

@Controller
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ReviewImageService reviewImageService;
	
//	@RequestMapping("/testhome")
//	public String getById(ReviewImagevo reviewImagevo, Model model) {
//		model.addAttribute("review",reviewImageService.getImgById(reviewImagevo));
//		return "/main/homemain";
//	}
	
	@RequestMapping("/testhome")
	public String getReviewImagevo(ReviewImagevo reviewImagevo, Model model) {
		System.out.println(reviewImagevo.toString());
		reviewImagevo.setImg_id(1);
		model.addAttribute("review", reviewImageService.getReviewImagevo(reviewImagevo));
		System.out.println(reviewImagevo.toString());
		return "/main/homemain";
	}
}
