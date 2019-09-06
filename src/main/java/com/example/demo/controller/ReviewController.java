package com.example.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.Commentvo;
import com.example.demo.domain.review.ReviewImagevo;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.example.demo.service.review.CommentService;
import com.example.demo.service.review.ReviewRepository;
import com.example.demo.service.review.ReviewService;
import com.example.demo.service.review.image.ReviewImageService;
import com.example.demo.service.user.UserRepository;
import com.example.demo.service.user.UserService;

@SessionAttributes("uservo") //uservo객체를 세션에 등록하기 위한 어노테이션
@Controller
public class ReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	ReviewService reviewService;

	@Autowired
	UserService userService;

	@Autowired
	CommentService commentService;
	
	@Autowired
	ReviewImageService reviewImageService;
	@Autowired
	UserRepository userRepo;

	ReviewRepository reviewRepo;
	
	
	EntityManager em;	

	@ModelAttribute("uservo")
	public Uservo setUservo() {
		return new Uservo();
	}
	

	@RequestMapping("/testhome")
	public String getReviewImagevo(ReviewImagevo reviewImagevo, Model model) {
		reviewImagevo.setImgId(1);
		model.addAttribute("review", reviewImageService.getReviewImagevo(reviewImagevo));
		return "th/main/homemain";
	}

	@GetMapping("/insertReview")
	public String insertReview(@ModelAttribute("uservo") Uservo uservo) {
		if (uservo.getNickname() == null) { // nickname대신 userId로 조건을 줘야하나?
			return "redirect:login";
		}
		return "th/review/reviewWrite";
	}

	@PostMapping("/insertReview")

	public String insertReview(@ModelAttribute("uservo") Uservo uservo, ReviewRegistrationvo reviewRegistrationvo, Model model) {
		if (uservo.getNickname() == null) {
//			model.addAttribute("userId", uservo);
//			logger.info(uservo.toString());
			return "redirect:login";
		}
		System.out.println(uservo.toString());
		
		reviewRegistrationvo.setUservo(uservo);
		reviewService.insertReview(reviewRegistrationvo);
		return "redirect:doReviewList";
	}

	@GetMapping("/doReviewView")
	public String getReviewVIew(@ModelAttribute("uservo") Uservo uservo, ReviewRegistrationvo reviewRegistrationvo, Model model) {
		if (uservo.getNickname() == null) {
			return "redirect:login";
		}
		model.addAttribute("reviewView", reviewService.selectReviewView(reviewRegistrationvo));
		model.addAttribute("commentList", commentService.selectCommentList(reviewRegistrationvo));
		return "th/review/reviewView"; 
	}
	
	@PostMapping("/updateReviewView")
	public String updateReview(@ModelAttribute("uservo") Uservo uservo, ReviewRegistrationvo reviewRegistrationvo) {
		if (uservo.getNickname() == null) {
			return "redirect:login";
		}
		
//		logger.info(uservo.toString());
//		logger.info(reviewRegistrationvo.toString());
		reviewService.updateReview(reviewRegistrationvo);		
		return "forward:doReviewList";
	}
	@GetMapping("/deleteReviewView")
	public String deleteReview(@ModelAttribute("uservo") Uservo uservo, ReviewRegistrationvo reviewRegistrationvo) {
		if (uservo.getNickname() == null) {
			return "redirect:login";
		}
				
		
		reviewService.deleteReview(reviewRegistrationvo);
		return "forward:doReviewList";
	}
	
	@RequestMapping("/doReviewList")
	public String getReviewList(@ModelAttribute("uservo") Uservo uservo,
			Model model, ReviewRegistrationvo reviewRegistrationvo, Commentvo commentvo) {
		if (uservo.getNickname()== null) {
			return "redirect:login";
		}

		List<ReviewRegistrationvo> reviewList = reviewService.selectReviewList(reviewRegistrationvo);

		commentvo.setReviewRegistrationvo(reviewRegistrationvo);
//		model.addAttribute("reviewAndNickName", reviewService.selectReviewJoinUserNickName(uservo, reviewRegistrationvo, commentvo));		
		model.addAttribute("reviewList", reviewList);
		
//		logger.info(model.toString());
		return "th/review/reviewList";

	}
	
	
}
