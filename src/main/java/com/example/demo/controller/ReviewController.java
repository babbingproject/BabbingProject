package com.example.demo.controller;

import java.util.ArrayList;
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
import com.example.demo.domain.review.AjaxReviewImagevo;
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
		
		System.out.println("리뷰vo에 리뷰 아이디 확인 : "+reviewRegistrationvo.getReviewId());
		
		List<AjaxReviewImagevo> ajaxReviewImgList = reviewImageService.getAjaxReviewImgList(reviewRegistrationvo.getReviewId());
		for (int i = 0; i <= (ajaxReviewImgList.size()-1); i++) {
			ReviewImagevo reviewImagevo = new ReviewImagevo();
			reviewImagevo.setImg(ajaxReviewImgList.get(i).getAjaxReviewImg());
			reviewImagevo.setReviewRegistrationvo(reviewRegistrationvo);
			reviewImageService.updateReviewImg(reviewImagevo);
		}
		
//		System.out.println("리뷰이미지테이블에 아젝스이미지 테이블의 이미지가 들어갔는가? "+reviewImagevo.toString());
//		System.out.println("리뷰이미지테이블에 리뷰아이디가 들어갔는가?? "+reviewImagevo.getReviewRegistrationvo().getReviewId().toString());
		int deleteUploadedAjaxReviewId = ajaxReviewImgList.get(0).getReviewId();
		reviewImageService.deleteAjaxImgUploadFinished(deleteUploadedAjaxReviewId);
		return "redirect:doReviewList";
	}

	@RequestMapping(value = "/doReviewView", method = RequestMethod.GET)
	public String getReviewVIew(Model model, int reviewId) {
		System.err.println(reviewId);
//	      model.addAttribute("reviewView", reviewRepo.findById(reviewId).get());
		model.addAttribute("reviewView", reviewService.getReviewView(reviewId));
		model.addAttribute("reviewImgList", reviewImageService.getReviewImgList(reviewId));
		return "th/review/reviewView";
	}

	@RequestMapping("/deleteReviewView")
	public String deleteReview(int reviewId) {
		reviewService.deleteReview(reviewId);
		return "forward:doReviewList";
	}

	@RequestMapping(value = "/doReviewViewUpdate", method = RequestMethod.GET)
	public String doUpdateReview(Model model, int reviewId) {
		System.err.println(reviewId);
		ReviewImagevo reviewImagevo = new ReviewImagevo();
		ReviewRegistrationvo reviewRegistrationvo = new ReviewRegistrationvo();
		reviewRegistrationvo.setReviewId(reviewId);
		reviewImagevo.setReviewRegistrationvo(reviewRegistrationvo);
		System.out.println("리뷰 수정 이미지 리스트 : "+reviewImageService.getReviewImgList(reviewId).toString());
		model.addAttribute("reviewView", reviewService.getReviewView(reviewId));
		model.addAttribute("reviewImgList", reviewImageService.getReviewImgList(reviewId));
		
	return "th/review/reviewModify";		
	}

}
