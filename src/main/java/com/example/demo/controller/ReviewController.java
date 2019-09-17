package com.example.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.ReviewImagevo;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.example.demo.service.review.CommentService;
import com.example.demo.service.review.ReviewRepository;
import com.example.demo.service.review.ReviewService;
import com.example.demo.service.review.image.ReviewImageService;
import com.example.demo.service.user.UserRepository;
import com.example.demo.service.user.UserService;

@Controller
public class ReviewController {

	
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
	
	@Autowired
	ReviewRepository reviewRepo;
	
	EntityManager em;	

	@RequestMapping("/testhome")
	public String getReviewImagevo(ReviewImagevo reviewImagevo, Model model) {
		reviewImagevo.setImgId(1);
		model.addAttribute("review", reviewImageService.getReviewImagevo(reviewImagevo));
		return "th/main/homemain";
	}
	
	@RequestMapping("/doReviewList")
	public String getReviewList(Model model) {
		List<ReviewRegistrationvo> reviewList = reviewService.selectReviewList();
		model.addAttribute("reviewList", reviewList);
		return "th/review/reviewList";
	}

	@GetMapping("/insertReview")
	public String insertReview() {
		return "th/review/reviewWrite";
	}

	@PostMapping("/insertReview")
	public String insertReview(int userId, ReviewRegistrationvo reviewRegistrationvo) {
		reviewRegistrationvo.setUservo(userRepo.findById(userId).get());
		
		reviewService.insertReview(reviewRegistrationvo);
		
		/*
		 * int reviewId = reviewService.createReviewId(); System.err.println(reviewId);
		 * List<AjaxReviewImagevo> ajaxReviewImgList =
		 * reviewService.selectAjaxReviewImgList(reviewId);
		 * System.out.println(ajaxReviewImgList.toString()); ReviewImagevo reviewImagevo
		 * = new ReviewImagevo();
		 * reviewImagevo.setImg(ajaxReviewImgList.get(ajaxReviewImgList.listIterator().
		 * nextIndex()).getAjaxReviewImg());
		 * reviewImageService.insertReviewImg(reviewImagevo);
		 * System.out.println(reviewImagevo.getImg().toString());
		 */		
		
		return "redirect:doReviewList";
	}

	@RequestMapping(value = "/doReviewView", method=RequestMethod.GET)
	public String getReviewVIew(Model model, int reviewId) {
		System.err.println(reviewId);
//		model.addAttribute("reviewView", reviewRepo.findById(reviewId).get());
		model.addAttribute("reviewView", reviewService.selectReviewView(reviewId));
		model.addAttribute("reviewImgList", reviewService.selectAjaxReviewImgList(reviewId));
		return "th/review/reviewView"; 
	}
	
	@RequestMapping("/deleteReviewView")
	public String deleteReview(int reviewId) {
		reviewService.deleteReview(reviewId);
		return "forward:doReviewList";
	}
	
	@RequestMapping("/updateReviewView")
	public String updateReview(Uservo uservo, ReviewRegistrationvo reviewRegistrationvo) {
		reviewService.updateReview(reviewRegistrationvo);		
		return "forward:doReviewList";
	}
	
	
	
	
}

