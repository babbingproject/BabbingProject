package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.ReviewImagevo;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.example.demo.service.review.ReviewService;
import com.example.demo.service.review.image.ReviewImageService;
import com.example.demo.service.user.UserRepository;
import com.example.demo.service.user.UserService;
import com.querydsl.core.Tuple;

@Controller
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ReviewImageService reviewImageService;
	@Autowired
	UserRepository userRepo;
	
//	@RequestMapping("/testhome")
//	public String getById(ReviewImagevo reviewImagevo, Model model) {
//		model.addAttribute("review",reviewImageService.getImgById(reviewImagevo));
//		return "/main/homemain";
//	}
	
	@RequestMapping("/testhome")
	public String getReviewImagevo(ReviewImagevo reviewImagevo, Model model) {
		System.out.println(reviewImagevo.toString());
		reviewImagevo.setImgId(1);
		model.addAttribute("review", reviewImageService.getReviewImagevo(reviewImagevo));
		System.out.println(reviewImagevo.toString());
		return "/main/homemain";
	}
	/*
	 * @RequestMapping("") public String getReviewUserInfo() {
	 * 
	 * 
	 * return"/review/review"; }
	 */
	@GetMapping("/insertReview")
	public String insertReview() {
		return "/review/reviewWrite";
	}
	@PostMapping("/insertReview")
	public String insertReview(ReviewRegistrationvo reviewRegistrationvo, Uservo uservo) {
		userService.insertUserId(uservo);
		reviewService.insertReview(reviewRegistrationvo, uservo);
		return "redirect:doReviewList";
	}
	@GetMapping("/doReviewView")
	public String reviewVIew(Uservo uservo, ReviewRegistrationvo reviewRegistrationvo, Model model) {
		int userId =uservo.getUserId();
		
		reviewRegistrationvo.setUserId(userId);
		Tuple result = reviewService.selectReviewIdJoinUserId(uservo,reviewRegistrationvo);
		
		model.addAttribute("joinReviewList", result);
		
		System.out.println(result.toString());
		
		return "/review/reviewView";
	}
}
