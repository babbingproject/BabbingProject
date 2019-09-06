package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.domain.mypage.Advertisementvo;
import com.example.demo.domain.mypage.Uservo;
import com.example.demo.service.campaign.CampaignService;

@SessionAttributes("uservo")
@Controller
public class MyPageController {
	
	@Autowired
	CampaignService campaignService;
	
	@RequestMapping("/getUserMyPage")
	public String getUserMyPage(Uservo uservo, Model model) {		
				
		return "th/mypage/userMyPage";
	}
	
	@RequestMapping("/getAdvertisementMyPage")
	public String getAdvertisementMyPage(int advertisement_id, Model model) {
		
		
		
		return "th/mypage/advertisementMyPage";
	}
}
