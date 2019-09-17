package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.example.demo.utils.SearchPaging;


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
	public String goIndex1(Model model, String followerMe, HttpSession httpSession) {
		
		System.out.println("SESSION" + httpSession.getServletContext());

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
		System.out.println(checkingScrap.getScrapvo());
		System.out.println(reviewNewestList);
		System.out.println("checkingchecking" +reviewNewestList.get(1).getUservo().getUserId());
		System.out.println("CHECKING PUT LIST 9/12 19:35" + checkingPutList);
		System.out.println("CHECKING ADVERTISEMENT NICKNAME" + checkingPutList.get(1).getAdvvo().getAdvertisementname());

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
		List<Object[]> everythingTopSixObject = reviewService.getEverythingTopSixObject();
		
		List<Object[]> businessFieldKorObject = reviewService.getBusinessFieldOneObject();
		List<ReviewRegistrationvo> businessFieldKor = reviewService.getBusinessFieldOne();
		
		List<Object[]> businessFieldWesObject = reviewService.getBusinessFieldTwoObject();
		List<ReviewRegistrationvo> businessFieldWes = reviewService.getBusinessFieldTwo();

		List<Object[]> businessFieldJpnObject = reviewService.getBusinessFieldThreeObject();
		List<ReviewRegistrationvo> businessFieldJpn = reviewService.getBusinessFieldThree();
		
		List<Object[]> businessFieldChnObject = reviewService.getBusinessFieldFourObject();
		List<ReviewRegistrationvo> businessFieldChn = reviewService.getBusinessFieldFour();
		
		List<Object[]> businessFieldSnkObject = reviewService.getBusinessFieldFiveObject();
		List<ReviewRegistrationvo> businessFieldSnk = reviewService.getBusinessFieldFive();
		
		List<Object[]> businessFieldFstObject = reviewService.getBusinessFieldSixObject();
		List<ReviewRegistrationvo> businessFieldFst = reviewService.getBusinessFieldSix();
		
		List<Object[]> businessFieldCafObject = reviewService.getBusinessFieldSevenObject();
		List<ReviewRegistrationvo> businessFieldCaf = reviewService.getBusinessFieldSeven();

		switch(type) {
		case "all":

			for(int i = 0; i < everythingTopSix.size(); i ++) {
				CheckingScrap checkingScrap = new CheckingScrap();
				checkingScrap.setReviewRegistrationvo(everythingTopSix.get(i));
				checkingScrap.setUservo(everythingTopSix.get(i).getUservo());
				checkingScrap.setScrapvo(scrapService.checkScrap(everythingTopSix.get(i).getReviewId(), followerMe));

				checkingScrap.setImg(everythingTopSixObject);

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

				System.out.println("TESTING OBJECT LIST " +checkingScrap.getImg());
				System.out.println(checkingScrap.getScrapvo());
				System.out.println("GET KOR FIELD'S EACH REVIEWID" + businessFieldKor.get(i).getReviewId());

				testing.add(checkingScrap);
				
			}
			break;

		case "wes":
			for(int i = 0; i < businessFieldWes.size(); i ++) {
				CheckingScrap checkingScrap = new CheckingScrap();
				checkingScrap.setReviewRegistrationvo(businessFieldWes.get(i));
				checkingScrap.setUservo(businessFieldWes.get(i).getUservo());
				checkingScrap.setScrapvo(scrapService.checkScrap(businessFieldWes.get(i).getReviewId(), followerMe));
				checkingScrap.setImg(businessFieldWesObject);
				testing.add(checkingScrap);
			}
			break;
		case "jpn":
			for(int i = 0; i < businessFieldJpn.size(); i ++) {
				CheckingScrap checkingScrap = new CheckingScrap();
				checkingScrap.setReviewRegistrationvo(businessFieldJpn.get(i));
				checkingScrap.setUservo(businessFieldJpn.get(i).getUservo());
				checkingScrap.setScrapvo(scrapService.checkScrap(businessFieldJpn.get(i).getReviewId(), followerMe));
				checkingScrap.setImg(businessFieldJpnObject);
				testing.add(checkingScrap);
			}
			break;
		case "chn":
			for(int i = 0; i < businessFieldChn.size(); i ++) {
				CheckingScrap checkingScrap = new CheckingScrap();
				checkingScrap.setReviewRegistrationvo(businessFieldChn.get(i));
				checkingScrap.setUservo(businessFieldChn.get(i).getUservo());
				checkingScrap.setScrapvo(scrapService.checkScrap(businessFieldChn.get(i).getReviewId(), followerMe));
				checkingScrap.setImg(businessFieldChnObject);
				testing.add(checkingScrap);
			}
			break;
		case "snk":
			for(int i = 0; i < businessFieldSnk.size(); i ++) {
				CheckingScrap checkingScrap = new CheckingScrap();
				checkingScrap.setReviewRegistrationvo(businessFieldSnk.get(i));
				checkingScrap.setUservo(businessFieldSnk.get(i).getUservo());
				checkingScrap.setScrapvo(scrapService.checkScrap(businessFieldSnk.get(i).getReviewId(), followerMe));
				checkingScrap.setImg(businessFieldSnkObject);
				testing.add(checkingScrap);
			}
			break;
		case "fst":
			for(int i = 0; i < businessFieldFst.size(); i ++) {
				CheckingScrap checkingScrap = new CheckingScrap();
				checkingScrap.setReviewRegistrationvo(businessFieldFst.get(i));
				checkingScrap.setUservo(businessFieldFst.get(i).getUservo());
				checkingScrap.setScrapvo(scrapService.checkScrap(businessFieldFst.get(i).getReviewId(), followerMe));
				checkingScrap.setImg(businessFieldFstObject);
				testing.add(checkingScrap);
			}
			break;
		case "caf":
			for(int i = 0; i < businessFieldCaf.size(); i ++) {
				CheckingScrap checkingScrap = new CheckingScrap();
				checkingScrap.setReviewRegistrationvo(businessFieldCaf.get(i));
				checkingScrap.setUservo(businessFieldCaf.get(i).getUservo());
				checkingScrap.setScrapvo(scrapService.checkScrap(businessFieldCaf.get(i).getReviewId(), followerMe));
				checkingScrap.setImg(businessFieldCafObject);
				testing.add(checkingScrap);
			}
			break;

		default :
		}
		return testing;
	}
		@RequestMapping("/search")
		public String goToSearch(Searchvo searchKeyword, Model model, @RequestParam(defaultValue = "0")int page) {

			List<CheckingScrap> checkingScrapList = new ArrayList();
			List<ReviewRegistrationvo> reviewList = reviewService.findAll(); 
			
			Page<ReviewRegistrationvo> reviewRegistrationvoPage = reviewService.getSearchKeywordPage(searchKeyword.getSearchKeyword(), PageRequest.of(page, 4));
			List<Object[]> review = reviewService.getSearchKeyword(searchKeyword.getSearchKeyword());
			List<SearchPaging> searchingPaging = new ArrayList();
			System.out.println(reviewRegistrationvoPage);
			System.out.println("review object list " + review.get(1));
			if(searchKeyword.getSearchKeyword()!="") {
				
				switch (searchKeyword.getTypes()) {
				case "review" :

					if(reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()).isEmpty()) {
						model.addAttribute("nothing", "리뷰 검색 결과가 없습니다");
						break;
					}

					
					model.addAttribute("reviewSearch", reviewService.getSearchKeyword(searchKeyword.getSearchKeyword()));

					System.out.println("리뷰리뷰리뷰리뷰did it come in here?");
					for(int i = 0; i < review.size(); i++) {
						SearchPaging searchPaging = new SearchPaging();
//						searchPaging.setReview(review.get(i));
						searchPaging.setReviewRegistrationvoPage(reviewService.getSearchKeywordPage(searchKeyword.getSearchKeyword(), PageRequest.of(page, 4)));
						searchPaging.setReviewImage(reviewService.getSearchKeywordPage(searchKeyword.getSearchKeyword(), PageRequest.of(page, 4)).getContent().get(i).getReviewImgList().get(i).getImg());
						searchingPaging.add(searchPaging);
					}
					model.addAttribute("review", searchingPaging);

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

		System.out.println("USER THAT IS LOGGED IN   " + followerMe);
		System.out.println("USER THAT HAS WROTE THIS CURRENT REVIEW    " + reviewUserId);
		System.out.println("REVIEW'S ID   " + reviewId);

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
