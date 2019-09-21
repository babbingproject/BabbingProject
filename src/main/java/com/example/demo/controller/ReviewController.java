package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.AjaxReviewImagevo;
import com.example.demo.domain.review.Commentvo;
import com.example.demo.domain.review.ReviewImagevo;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.example.demo.service.rank.RankService;
import com.example.demo.service.review.CommentService;
import com.example.demo.service.review.ReviewRepository;
import com.example.demo.service.review.ReviewService;
import com.example.demo.service.review.image.ReviewImageService;
import com.example.demo.service.scrap.ScrapService;
import com.example.demo.service.user.UserRepository;
import com.example.demo.service.user.UserService;
import com.example.demo.utils.CheckingScrap;

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
	
	@Autowired
	ScrapService scrapService;
	
	@Autowired
	RankService rankService;

	EntityManager em;

	@RequestMapping("/testhome")
	public String getReviewImagevo(ReviewImagevo reviewImagevo, Model model) {
		reviewImagevo.setImgId(1);
		model.addAttribute("review", reviewImageService.getReviewImagevo(reviewImagevo));
		return "th/main/homemain";
	}
	
	

//	@RequestMapping("/doReviewList")
//	public String getReviewList(Model model) {
//		List<ReviewRegistrationvo> reviewList = reviewService.selectReviewList();
//		model.addAttribute("reviewList", reviewList);
//		return "th/review/reviewList";
//	}
	
	@RequestMapping("/doReviewList")
	public String getReviewList(HttpSession httpSession, Model model) {
		String loggedInID = (String) httpSession.getAttribute("username");
		List<ReviewRegistrationvo> reviewList = reviewService.getEverythingWOLimit();
		List<CheckingScrap> reviewListCheckScrap = new ArrayList();
		for(int i = 0; i < reviewList.size(); i++) {
			CheckingScrap checkingScrap = new CheckingScrap();
			checkingScrap.setReviewRegistrationvo(reviewList.get(i));
			checkingScrap.setScrapvo(scrapService.checkScrap(reviewList.get(i).getReviewId(), loggedInID));
			checkingScrap.setFollowvo(rankService.checkFollowing(loggedInID, reviewList.get(i).getUservo().getNickname()));
			reviewListCheckScrap.add(checkingScrap);
			
			
		}
		model.addAttribute("reviewList", reviewListCheckScrap);
		return "th/review/reviewList";
	}
	@GetMapping("/insertReview")
	public String insertReview() {
		return "th/review/reviewWrite";
	}

	@PostMapping("/insertReview")
	public String insertReview(int userId, ReviewRegistrationvo reviewRegistrationvo, String imgSrc) {
		reviewRegistrationvo.setUservo(userRepo.findById(userId).get());
//		System.out.println("리뷰이미지가 여러개 들어왔나?"+imgSrc.toString());
		reviewService.insertReview(reviewRegistrationvo);
//		reviewImagevo.setReviewRegistrationvo(reviewRegistrationvo);
		if (imgSrc.isEmpty()) {
			return "redirect:doReviewList";
		}else {
			String[] array = imgSrc.split(",");
			
			for (int i = 0; i < array.length; i++) {
				String replaceSrc = array[i].replace("s_", "").trim();
				ReviewImagevo reviewImagevo = new ReviewImagevo();
				reviewImagevo.setImg(replaceSrc);
				reviewImagevo.setReviewRegistrationvo(reviewRegistrationvo);
				reviewImageService.updateReviewImg(reviewImagevo);
				System.out.println("array ["+i+"]"+ replaceSrc);
			}
		}
	
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
	
	@PostMapping("/ReviewViewUpdate")
	public String ReviewViewUpdate(int userId, ReviewRegistrationvo reviewRegistrationvo, Optional<String> imgSrc) {
		System.out.println("리뷰 업데이트 userId : "+userId);
		System.out.println("리뷰 업데이트 reviewRegistrationvo : " +reviewRegistrationvo.toString());
//		reviewRegistrationvo.setUservo(userRepo.findById(userId).get());
		Uservo uservo = new Uservo();
		uservo.setUserId(userId);
		reviewRegistrationvo.setUservo(uservo);
		int reviewId = reviewRegistrationvo.getReviewId();
		System.out.println(reviewId);
//		reviewService.modifyReviewView(reviewRegistrationvo);
		reviewImageService.getReviewImgList(reviewId);
//		System.out.println(imgSrc.isEmpty());
		Optional<Optional<String>> checkImgSrc = Optional.ofNullable(imgSrc);
		System.out.println(checkImgSrc.toString());
		if (checkImgSrc.get().isPresent()) {
			System.out.println("imgSrc값이 존재할때");
			
			String[] array = imgSrc.get().toString().split(",");
			for (int i = 0; i < array.length; i++) {
				String replaceSrc = array[i].replace("s_", "").trim();
				ReviewImagevo reviewImagevo = new ReviewImagevo();
				reviewImagevo.setImg(replaceSrc);
				reviewImagevo.setReviewRegistrationvo(reviewRegistrationvo);
				reviewImageService.updateReviewImg(reviewImagevo);
				System.out.println("array ["+i+"]"+ replaceSrc);
			}
		}else {
			System.out.println("imgSrc값이 존재하지 않을 때");
			return "redirect:doReviewList";
		}
		
		return "redirect:doReviewList";
		
	}
	
	@RequestMapping("imageList")
	@ResponseBody
	public List<ReviewImagevo> imageList(int reviewId) throws Exception {
		System.err.println("showImageList ajax : "+reviewId);
		
//		ReviewRegistrationvo reviewRegistrationvo = new ReviewRegistrationvo();
//		reviewRegistrationvo.setReviewId(reviewId);
//		
//		List<Commentvo> commentList = commentService.getCommentList(reviewRegistrationvo);
//		return commentList;
		
		List<ReviewImagevo> imagetList =  reviewImageService.getReviewImgList(reviewId);
		
		System.out.println(imagetList.toString());
		return imagetList;
	}

}
