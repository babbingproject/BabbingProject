package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.main.Searchvo;
import com.example.demo.domain.mypage.Advertisementvo;
import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.example.demo.service.advertisement.AdvertisementService;
import com.example.demo.service.rank.RankService;
import com.example.demo.service.review.ReviewService;
import com.example.demo.service.review.image.ReviewImageService;
import com.example.demo.service.scrap.ScrapService;
import com.example.demo.service.user.UserService;
import com.example.demo.utils.CheckingPut;
import com.example.demo.utils.CheckingRanking;
import com.example.demo.utils.CheckingScrap;


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
	@Autowired
	RankService rankService;
	@Autowired
	ScrapService scrapService;

	
	@RequestMapping("/home")
	public String goIndex() {
		
		return "th/main/homemain";
	}
	//메인 홈페이지! 계속 추가추가 수정수정하자!
	@RequestMapping("/index")
	public String goIndex1(Model model, String followerMe) {
//		List<Object[]> UservoList = userService.getUservoListOrderByFollowingCountDes();
//		List<Object[]> advvoList = advService.getAdvertisementvoOrderByWeightAvg();
//		model.addAttribute("newestreview", reviewService.getNewestReview());
		model.addAttribute("everything", reviewService.getEverythingTopSix());
	
		List<CheckingRanking> checkingList = new ArrayList();
		List<CheckingPut> checkingPutList = new ArrayList();
		List<CheckingScrap> checkingScrapNewList = new ArrayList();
		List<CheckingScrap> checkingScrapTopSixList = new ArrayList();
		List<Uservo> userList = rankService.getAllUser();
		List<Advertisementvo> advList = advService.findAll();
		List<ReviewRegistrationvo> reviewNewestList = reviewService.getNewestReview();
		List<ReviewRegistrationvo> reviewEverythingTopSix = reviewService.getEverythingTopSix();
		for(int i = 0; i < userList.size(); i++) {
			CheckingRanking checkingRanking = new CheckingRanking();
			checkingRanking.setUservo(userList.get(i));
			checkingRanking.setFollowvo(rankService.checkFollowing(followerMe, userList.get(i).getNickname()));
			checkingList.add(checkingRanking);
		}
		for(int i = 0; i < advList.size(); i++) {
			CheckingPut checkingPut = new CheckingPut();
			checkingPut.setAdvvo(advList.get(i));
			checkingPut.setPutvo(rankService.checkPut(followerMe, advList.get(i).getAdvertisementname()));
			checkingPutList.add(checkingPut);
		}
		for(int i = 0; i < reviewNewestList.size(); i++) {
			CheckingScrap checkingScrap = new CheckingScrap();
			checkingScrap.setReviewRegistrationvo(reviewNewestList.get(i));
			System.out.println("reviewList ++!!" +reviewNewestList.get(i));
			checkingScrap.setScrapvo(scrapService.checkScrap(reviewNewestList.get(i).getReviewId(), followerMe));
			
			System.out.println("NUMBER THAT IS RUNNING NOW "+i);
			System.out.println("reviewId that needs to be inserted but displays this number = "+reviewNewestList.get(i).getUservo().getUserId());
			System.out.println("scrapService three sccrap?????????" +scrapService.checkScrap(reviewNewestList.get(i).getReviewId(), followerMe));
			checkingScrapNewList.add(checkingScrap);
		}
		for(int i = 0; i < reviewEverythingTopSix.size(); i ++) {
			CheckingScrap checkingScrap = new CheckingScrap();
			checkingScrap.setReviewRegistrationvo(reviewEverythingTopSix.get(i));
			checkingScrap.setScrapvo(scrapService.checkScrap(reviewEverythingTopSix.get(i).getReviewId(), followerMe));
			checkingScrapTopSixList.add(checkingScrap);
		}
		CheckingScrap checkingScrap = new CheckingScrap();
		System.out.println(checkingScrap.getScrapvo());
		System.out.println(reviewNewestList);
		System.out.println("checkingchecking" +reviewNewestList.get(1).getUservo().getUserId());
		model.addAttribute("uservo", checkingList);
		model.addAttribute("advvo", checkingPutList);
		model.addAttribute("newestreview", checkingScrapNewList);
		model.addAttribute("everything", checkingScrapTopSixList);
		System.out.println(followerMe);
		return "th/main/index1";
	}
	
	@ResponseBody
	@RequestMapping("tabMenu")
	public List<Object[]> tabMenu(String type, Model model) {
		int value = 0;
		System.out.println("types is " +type);
		List<Object[]> testing = null;
		switch(type) {
		case "all":
//			testing = reviewService.getEverythingTopSix();
			value = 0;
			break;
		case "kor":
			testing = reviewService.getBusinessFieldOne();
			value = 1;
			break;
		case "wes":
			testing =reviewService.getBusinessFieldTwo();
			System.out.println("case wes");
			value = 2;
			break;
		case "jpn":
			testing = reviewService.getBusinessFieldThree();
			value = 3;
			break;
		case "chn":
			testing = reviewService.getBusinessFieldFour();
			value = 4;
			break;
		case "snk":
			testing = reviewService.getBusinessFieldFive();
			value = 5;
			break;
		case "fst":
			testing = reviewService.getBusinessFieldSix();
			value = 6;
			break;
		case "caf":
			testing = reviewService.getBusinessFieldSeven();
			value = 7;
			break;
		default :
		}
		return testing;
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
	

	
	//서치페이지로 가기!
		@RequestMapping("/search")
		public String goToSearch(Searchvo searchKeyword, Model model, @RequestParam(defaultValue = "0")int page) {
			System.out.println(searchKeyword.getTypes());
			System.out.println(searchKeyword.getSearchKeyword());
		
			List<CheckingScrap> checkingScrapList = new ArrayList();
			List<ReviewRegistrationvo> reviewList = reviewService.findAll(); 
			
			if(searchKeyword.getSearchKeyword()!="") {
				
				switch (searchKeyword.getTypes()) {
				case "review" :
//					System.out.println(reviewService.getSearchKeyword(searchKeyword.getSearchKeyword(), PageRequest.of(page, 5)));
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
//					System.out.println("광광광고고고고고고곡 여기에 왔나요?");
//					if(advService.getSearchKeyword(searchKeyword.getSearchKeyword()).isEmpty()) {
//						model.addAttribute("nothing", "기업 검색 결과가 없습니다");
//						break;
//					}
//					model.addAttribute("advertisementSearch", advService.getSearchKeyword(searchKeyword.getSearchKeyword()));
					break;
				}
			} else {
				model.addAttribute("nothing", "검색 결과가 없습니다");
			}
//			System.out.println("reviewREVIEWREIVRWREIVEW " + reviewService.getSearchKeyword(searchKeyword.getSearchKeyword(), PageRequest.of(page, 5)));
			System.out.println("reviewREVIEWREIVRWREIVEW " + reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()));
			System.out.println("USERUSERUSERUSERUSER " + userService.getSearchKeyword(searchKeyword.getSearchKeyword()));
//			System.out.println("ADVADVADVADVADVasdvadv " + advService.getSearchKeyword(searchKeyword.getSearchKeyword()));
			return "th/main/search";
		}
	
	
//	public String getHomeMain(Uservo Uservo, Model model) {
//		List<Uservo> UservoList = userService.getUservoListOrderByFollowingCountDes(Uservo);
//		model.addAttribute("Uservo", UservoList);
//		System.out.println(UservoList);
//		return "main/homemain";
//	}
	
	@RequestMapping("/testsearch")
	public String showPage(Model model, @RequestParam(defaultValue="0")int page) {
		model.addAttribute("data", reviewService.findAll(PageRequest.of(page, 4)));
		model.addAttribute("currentPage", page);
		return "th/main/search";
	}
	
	


	
	//korean food list top six testing ajax
	@RequestMapping("/getkoreanfood")
	public String getKoreanFood(Model model) {
		model.addAttribute("businessone", reviewService.getBusinessFieldOne());
		return "th/main/reviewselector/getKoreanReview";
	}
	
	@ResponseBody
	@RequestMapping("/scrapButton")
	public int scrapButton(String followerMe, Integer reviewUserId, Integer reviewId) {
		int result = 0;
		System.out.println(followerMe);
		System.out.println(reviewUserId);
		System.out.println(reviewId);
		if(followerMe.isEmpty()) {
			result = -1;
			
		} else if(scrapService.checkScrap(reviewId, followerMe).isEmpty()) {
			scrapService.insertScrap(reviewId, followerMe);
			userService.scrapFactorIncrease(reviewUserId);
			result = 0;
		} else {
			scrapService.deleteScrap(reviewId, followerMe);
			userService.scrapFactorDecrease(reviewUserId);
			result = 1;
		}
		
		System.out.println("print result value" + result);
		return result;
	}

}
