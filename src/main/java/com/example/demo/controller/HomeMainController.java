package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.main.Searchvo;
import com.example.demo.domain.mypage.Uservo;
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
		List<Object[]> UservoList = userService.getUservoListOrderByFollowingCountDes();
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
		model.addAttribute("Uservo", UservoList);
		model.addAttribute("advvo", advvoList);
		return "th/main/index1";
	}
	
	//태원의 제2의 메인홈 테스팅 메소드. 화면 정보 다 뿌려주자자자자자
//	@RequestMapping("/taewonhome")
//	public String getHomeMain(Uservo Uservo, Model model) {
//		List<Object[]> UservoList = userService.getUservoListOrderByFollowingCountDes();
//		model.addAttribute("Uservo", UservoList);
//		System.out.println(UservoList);
//		return "main/homemain";
//	}
//	@RequestMapping("/board")
//	public String goBoard() {
//		return "board";
//	}
	
	//태원의 메인홈 테스팅 메소드. 화면 정보 열로 다 뿌려주기
//	@RequestMapping("/taewonhome")
//	public String getHomeMain(Uservo Uservo, Model model) {
//		List<Uservo> UservoList = userService.getUservoList(Uservo);
//		model.addAttribute("Uservo", UservoList);
//		System.out.println(UservoList);
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
	public String goToSearch(Searchvo searchKeyword, Model model) {
//		model.addAttribute("reviewSearch", reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()));
//		System.out.println(searchKeyword.getSearchKeyword());
//		System.out.println(reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()));
//		model.addAttribute("userSearch", userService.getSearchKeyword(searchKeyword.getSearchKeyword()));
//		model.addAttribute("advertisementSearch", advService.getSearchKeyword(searchKeyword.getSearchKeyword()));
//		
//		System.out.println(userService.getSearchKeyword(searchKeyword.getSearchKeyword()));
		System.out.println(searchKeyword.getTypes());
		System.out.println(searchKeyword.getSearchKeyword());
		String v = "review";
//		if (searchKeyword.getTypes() == v) {
//			System.out.println("did it come in here?");
//			model.addAttribute("reviewSearch", reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()));
//		} else if (searchKeyword.getTypes() == "user") {
//			System.out.println("did it come in here?");
//			model.addAttribute("userSearch", userService.getSearchKeyword(searchKeyword.getSearchKeyword()));
//
//		};
		if(searchKeyword.getSearchKeyword()!="") {
			
			switch (searchKeyword.getTypes()) {
			case "review" :
				System.out.println(reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()));
				if(reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()).isEmpty()) {
					model.addAttribute("nothing", "리뷰 검색 결과가 없습니다");
					break;
				}
				System.out.println("리뷰리뷰리뷰리뷰did it come in here?");
				model.addAttribute("reviewSearch", reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()));
				break;
			case "user" :
				if(userService.getSearchKeyword(searchKeyword.getSearchKeyword()).isEmpty()) {
					model.addAttribute("nothing", "유저 검색 결과가 없습니다");
					break;
				}
				System.out.println("유저유저유저유저 왔나오?");
				model.addAttribute("userSearch", userService.getSearchKeyword(searchKeyword.getSearchKeyword()));
				break;
			case "campaign" :
				
				break;
			case "advertisement" :
				System.out.println("광광광고고고고고고곡 여기에 왔나요?");
				if(advService.getSearchKeyword(searchKeyword.getSearchKeyword()).isEmpty()) {
					model.addAttribute("nothing", "기업 검색 결과가 없습니다");
					break;
				}
				model.addAttribute("advertisementSearch", advService.getSearchKeyword(searchKeyword.getSearchKeyword()));
				break;
			}
		} else {
			model.addAttribute("nothing", "검색 결과가 없습니다");
		}
		System.out.println("reviewREVIEWREIVRWREIVEW " + reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()));
		System.out.println("USERUSERUSERUSERUSER " + userService.getSearchKeyword(searchKeyword.getSearchKeyword()));
		System.out.println("ADVADVADVADVADVasdvadv " + advService.getSearchKeyword(searchKeyword.getSearchKeyword()));
		return "th/main/search";
	}
	
	
//	public String getHomeMain(Uservo Uservo, Model model) {
//		List<Uservo> UservoList = userService.getUservoListOrderByFollowingCountDes(Uservo);
//		model.addAttribute("Uservo", UservoList);
//		System.out.println(UservoList);
//		return "main/homemain";
//	}
	
	
	


	
	//korean food list top six testing ajax
	@RequestMapping("/getkoreanfood")
	public String getKoreanFood(Model model) {
		model.addAttribute("businessone", reviewService.getBusinessFieldOne());
		return "th/main/reviewselector/getKoreanReview";
	}

}
