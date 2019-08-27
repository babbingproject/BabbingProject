package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.main.Search;
import com.example.demo.domain.mypage.UserVO;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.example.demo.service.advertisement.AdvertisementService;
import com.example.demo.service.review.ReviewService;
import com.example.demo.service.review.image.ReviewImageService;
import com.example.demo.service.user.UserService;

@Controller
public class HomeMainController {

	@Autowired
	UserService userService;
	@Autowired
	AdvertisementService advService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	ReviewImageService reviewImageService;

	
	@RequestMapping("/home")
	public String goIndex() {
		
		return "th/main/homemain";
	}
	//메인 홈페이지! 계속 추가추가 수정수정하자!
	@RequestMapping("/index")
	public String goIndex1(Model model) {
		List<Object[]> uservoList = userService.getUservoListOrderByFollowingCountDes();
		List<Object[]> advvoList = advService.getAdvertisementvoOrderByWeightAvg();
		model.addAttribute("newestreview", reviewService.getNewestReview());
		model.addAttribute("everything", reviewService.getEverythingTopSix());
		model.addAttribute("businessone", reviewService.getBusinessFieldOne());
		model.addAttribute("businesstwo", reviewService.getBusinessFieldTwo());
		model.addAttribute("businessthree", reviewService.getBusinessFieldThree());
		model.addAttribute("businessfour", reviewService.getBusinessFieldFour());
		model.addAttribute("businessfive", reviewService.getBusinessFieldFive());
		model.addAttribute("businesssix", reviewService.getBusinessFieldSix());
		model.addAttribute("businessseven", reviewService.getBusinessFieldSeven());
		model.addAttribute("uservo", uservoList);
		model.addAttribute("advvo", advvoList);
		return "th/main/index1";
	}
	
	//태원의 제2의 메인홈 테스팅 메소드. 화면 정보 다 뿌려주자자자자자
//	@RequestMapping("/taewonhome")
//	public String getHomeMain(Uservo uservo, Model model) {
//		List<Object[]> uservoList = userService.getUservoListOrderByFollowingCountDes();
//		model.addAttribute("uservo", uservoList);
//		System.out.println(uservoList);
//		return "main/homemain";
//	}
//	@RequestMapping("/board")
//	public String goBoard() {
//		return "board";
//	}
	
	//태원의 메인홈 테스팅 메소드. 화면 정보 열로 다 뿌려주기
//	@RequestMapping("/taewonhome")
//	public String getHomeMain(Uservo uservo, Model model) {
//		List<Uservo> uservoList = userService.getUservoList(uservo);
//		model.addAttribute("uservo", uservoList);
//		System.out.println(uservoList);
//		return "main/homemain";
//	}
	
	//해당 리뷰 카테고리 선택해서 뿌려주기
//	@RequestMapping("/taewonhome")
//	public String getReviewCategories(Model model) {
//		List<Object[]> koreanReviewList = reviewService.getKoreanTopSix();
//		model.addAttribute("koreanReviewList", koreanReviewList);
//		return "main/homemain";
//	}
	
	//150개이상되는 데이터를 하나하나 입력하기 싫어서 이렇게 넣어볼려했는데 review_id에서 걸리네요..나중에 해결책 찾기
//	@RequestMapping("/quickinsert")
//	public String quickinsert() {
//		for(int i = 43; i < 157; i ++) {
//			ReviewImagevo review = new ReviewImagevo();
//			review.setImg("https://www.dropbox.com/s/r48ealh2taf052f/%EA%B9%80%EC%B2%9C%EC%9E%AC%EC%9D%98%EC%A1%B1%EB%B0%9C%EC%9D%B4%EB%B3%B4%EA%B3%B1%EB%8B%AD_%EC%8B%A0%EB%85%BC%ED%98%844.png?dl=0");
//			review.setImg_review("hope it inserts");
//			review.setReview_id(i);
//			reviewImageService.saveReviewImagevo(review);
//		}
//		
//		return "main/homemain";
//	}
	
	//카테고리 전체 부분, 리뷰 비즈니스첫번째항목
	@RequestMapping("/taewonhome")
	public String getEverything(Model model) {
		System.out.println(reviewService.getEverythingTopSix());
		model.addAttribute("everything", reviewService.getEverythingTopSix());
		model.addAttribute("businessone", reviewService.getBusinessFieldOne());
		model.addAttribute("businesstwo", reviewService.getBusinessFieldTwo());
		model.addAttribute("businessthree", reviewService.getBusinessFieldThree());
		model.addAttribute("businessfour", reviewService.getBusinessFieldFour());
		model.addAttribute("businessfive", reviewService.getBusinessFieldFive());
		model.addAttribute("businesssix", reviewService.getBusinessFieldSix());
		model.addAttribute("businessseven", reviewService.getBusinessFieldSeven());
		return "th/main/homemain";
	}
	
	//서치페이지로 가기!
	@RequestMapping("/search")
	public String goToSearch(Search searchKeyword, Model model) {
		model.addAttribute("reviewSearch", reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()));
		System.out.println(searchKeyword.getSearchKeyword());
		System.out.println(reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()));
		model.addAttribute("userSearch", userService.getSearchKeyword(searchKeyword.getSearchKeyword()));
		model.addAttribute("advertisementSearch", advService.getSearchKeyword(searchKeyword.getSearchKeyword()));
		
		System.out.println(userService.getSearchKeyword(searchKeyword.getSearchKeyword()));
		return "th/main/search";
		
	}
	
	
	

	@RequestMapping("/doReviewList")
	public String getReviewList(Model model) {
		
		List<UserVO> userInfo = new ArrayList<UserVO>();
		List<ReviewRegistrationvo> reviewList = new ArrayList<ReviewRegistrationvo>();
		reviewList = reviewService.selectReviewList();
		userInfo = reviewService.selectUservoInfo();
		
		model.addAttribute("userInfo", userInfo);
		
		model.addAttribute("reviewList", reviewList);
		
		return "th/review/reviewList";
	}

}
