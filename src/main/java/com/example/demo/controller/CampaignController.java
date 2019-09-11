package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.domain.campaign.Campaignvo;
import com.example.demo.domain.mypage.Advertisementvo;
import com.example.demo.domain.mypage.Uservo;
import com.example.demo.service.campaign.CampaignService;
import com.example.demo.service.campaign.ParticipantsService;


@SessionAttributes("usevo")
@Controller
public class CampaignController {

	@Autowired
	CampaignService campaignService;


	@Autowired
	ParticipantsService participantsService;


	// 캠페인 리스트 불러오기
	@RequestMapping("/getCampaignList")
	public String getCampaignList(Model model, Campaignvo campaignvo) {

		List<Campaignvo> campaignList = campaignService.getListByActive(campaignvo);
		model.addAttribute("campaignList", campaignList);
		return "th/campaign/campaign";
	}

	// 캠페인 정렬 코드 아직 미구현
	@GetMapping("/getCampaign")
	public String getCampaign(HttpSession session, Model model, Campaignvo campaignvo) {

		

		Campaignvo campInfo = campaignService.getCampaign(campaignvo);
		model.addAttribute("campaign", campInfo);
		model.addAttribute("participantsList", participantsService.getParticipantsList(campInfo.getCampaignId()));
		System.err.println("참여자 리스트 : " + participantsService.getParticipantsList(campInfo.getCampaignId()));

		if((Uservo)session.getAttribute("uservo") != null) {
			Uservo uservo = (Uservo)session.getAttribute("uservo");
			int userId = uservo.getUserId();
			model.addAttribute("participant", participantsService.getParticipants(userId, campInfo.getCampaignId()));
			System.err.println("참여자 객체 : " + participantsService.getParticipants(userId, campInfo.getCampaignId()));
			return "th/campaign/campaignView";
		}

	 
		return "th/campaign/campaignView";
	}


	@GetMapping("/insertCampaign")
	public String insertCampaignView() {
		return "th/campaign/campaignWrite";
	}
	

	@PostMapping("/insertCampaign")
	public String insertCampaign(Advertisementvo advertisementvo, Campaignvo campaignvo) {

		campaignvo.setAdvertisementvo(advertisementvo);
		campaignService.insertCampaign(campaignvo);

		return "redirect:getCampaignList";
	}
	
	@GetMapping("/updateCampaign")
	public String updateCampaignView(Model model, Campaignvo campaignvo) {
		model.addAttribute("campaign", campaignService.getCampaign(campaignvo));
		return "th/campaign/campaignModify";
	}

	@PostMapping("/updateCampaign")
	public String updateCampaign(Campaignvo campaignvo) {
		campaignService.updateCampaign(campaignvo);
		return "forward:getCampaignList";
	}

	// 캠페인 삭제
	@GetMapping("/deleteCampaign")
	public String deleteCampaign(Campaignvo campaignvo) {
		campaignService.deleteCampaign(campaignvo);
		return "forward:getCampaignList";
	}
}
