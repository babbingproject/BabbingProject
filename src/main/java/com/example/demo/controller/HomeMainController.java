package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

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
import com.example.demo.domain.review.ReviewImagevo;
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
	@RequestMapping("/")
	public String goIndex1(Model model, String followerMe) {

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
			
			checkingScrap.setScrapvo(scrapService.checkScrap(reviewNewestList.get(i).getReviewId(), followerMe));
			
		
			checkingScrapNewList.add(checkingScrap);
		}
		for(int i = 0; i < reviewEverythingTopSix.size(); i ++) {
			CheckingScrap checkingScrap = new CheckingScrap();
			checkingScrap.setReviewRegistrationvo(reviewEverythingTopSix.get(i));
			checkingScrap.setScrapvo(scrapService.checkScrap(reviewEverythingTopSix.get(i).getReviewId(), followerMe));
			checkingScrapTopSixList.add(checkingScrap);
		}
		CheckingScrap checkingScrap = new CheckingScrap();		
		model.addAttribute("uservo", checkingList);
		model.addAttribute("advvo", checkingPutList);
		model.addAttribute("newestreview", checkingScrapNewList);
		model.addAttribute("everything", checkingScrapTopSixList);

		return "th/main/index1";
	}
	
	@ResponseBody
	@RequestMapping("tabMenu")
	public List<CheckingScrap> tabMenu(String type, Model model, String followerMe) {

		List<CheckingScrap> testing = new ArrayList();
		List<ReviewRegistrationvo> everythingTopSix = reviewService.getEverythingTopSix();
		List<Object[]> businessFieldKorObject = reviewService.getBusinessFieldOneObject();
		List<ReviewRegistrationvo> businessFieldKor = reviewService.getBusinessFieldOne();
		List<ReviewRegistrationvo> businnesFieldWes = reviewService.getBusinessFieldTwo();
		List<ReviewRegistrationvo> businessFieldJpn = reviewService.getBusinessFieldThree();
		List<ReviewRegistrationvo> businessFieldChn = reviewService.getBusinessFieldFour();
		List<ReviewRegistrationvo> businessFieldSnk = reviewService.getBusinessFieldFive();
		List<ReviewRegistrationvo> businessFieldFst = reviewService.getBusinessFieldSix();
		List<ReviewRegistrationvo> businessFieldCaf = reviewService.getBusinessFieldSeven();
		switch(type) {
		case "all":

			for(int i = 0; i < everythingTopSix.size(); i ++) {
				CheckingScrap checkingScrap = new CheckingScrap();
				checkingScrap.setReviewRegistrationvo(everythingTopSix.get(i));
				checkingScrap.setScrapvo(scrapService.checkScrap(everythingTopSix.get(i).getReviewId(), followerMe));
				testing.add(checkingScrap);
			}
			break;
		case "kor":

			for(int i = 0; i < businessFieldKor.size(); i ++) {
				CheckingScrap checkingScrap = new CheckingScrap();
				checkingScrap.setReviewRegistrationvo(businessFieldKor.get(i));
				checkingScrap.setUservo(businessFieldKor.get(i).getUservo());
				checkingScrap.setScrapvo(scrapService.checkScrap(businessFieldKor.get(i).getReviewId(), followerMe));
				checkingScrap.setImg(businessFieldKorObject);
				
				testing.add(checkingScrap);
				
			}
			break;
		default :
		}
		model.addAttribute("everything", testing);
		return testing;
	}
		@RequestMapping("/search")
		public String goToSearch(Searchvo searchKeyword, Model model, @RequestParam(defaultValue = "0")int page) {

			List<CheckingScrap> checkingScrapList = new ArrayList();
			List<ReviewRegistrationvo> reviewList = reviewService.findAll(); 
			
			if(searchKeyword.getSearchKeyword()!="") {
				
				switch (searchKeyword.getTypes()) {
				case "review" :

					if(reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()).isEmpty()) {
						model.addAttribute("nothing", "리뷰 검색 결과가 없습니다");
						break;
					}
					
					model.addAttribute("reviewSearch", reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()));
					break;
				case "user" :
					if(userService.getSearchKeyword(searchKeyword.getSearchKeyword()).isEmpty()) {
						model.addAttribute("nothing", "유저 검색 결과가 없습니다");
						break;
					}
					
					model.addAttribute("userSearch", userService.getSearchKeyword(searchKeyword.getSearchKeyword()));
					break;
				case "campaign" :
					
					break;
				case "advertisement" :

					break;
				}
			} else {
				model.addAttribute("nothing", "검색 결과가 없습니다");
			}

			return "th/main/search";
		}
	

	@RequestMapping("/testsearch")
	public String showPage(Model model, @RequestParam(defaultValue="0")int page) {
		model.addAttribute("data", reviewService.findAll(PageRequest.of(page, 4)));
		model.addAttribute("currentPage", page);
		return "th/main/search";
	}
	

	@RequestMapping("/getkoreanfood")
	public String getKoreanFood(Model model) {
		model.addAttribute("businessone", reviewService.getBusinessFieldOne());
		return "th/main/reviewselector/getKoreanReview";
	}
	
	@ResponseBody
	@RequestMapping("/scrapButton")
	public int scrapButton(String followerMe, Integer reviewUserId, Integer reviewId) {
		int result = 0;

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

		return result;
	}

}
