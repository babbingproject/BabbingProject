package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.domain.campaign.Campaignvo;
import com.example.demo.domain.mypage.Advertisementvo;
import com.example.demo.service.campaign.CampaignService;
import com.example.demo.service.campaign.ParticipantsService;

@SessionAttributes("uservo")
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
	
	
	/*
	 * // 캠페인 조회
	 * 
	 * @GetMapping("/getCampaign") public String getCampaign(Model model, Campaignvo
	 * campaignvo) {
	 */

		 @GetMapping("/getCampaign")
		public String getCampaign(@ModelAttribute("member") Advertisementvo advertisementvo, Model model,Campaignvo campaignvo) {		

		Campaignvo campInfo = campaignService.getCampaign(campaignvo);
		model.addAttribute("campaign", campInfo);	
		model.addAttribute("participantsList",participantsService.getParticipantsList(campInfo.getCampaignId()));		
		model.addAttribute("participant", participantsService.getParticipants(advertisementvo.getAdvertisementId(),campInfo.getCampaignId()));
		
		return "th/campaign/campaignView";
		
		}
	
	/*
	 * model.addAttribute("campaign", campaignService.getCampaign(campaignvo));
	 * return "th/campaign/campaignView"; }
	 */
	
	@GetMapping("insertCampaign")
	public String insertCampaignView() {
		return "th/campaign/campaignWrite";
	}
	
	// 
	@PostMapping("/insertCampaign")
	public String insertCampaign(Advertisementvo advertisementvo, Campaignvo campaignvo) {
		
		campaignvo.setAdvertisementvo(advertisementvo);
		campaignService.insertCampaign(campaignvo);
		
		return "redirect:getCampaignList";
	}
	
	// 캠페인 수정
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
