package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.campaign.Campaignvo;
import com.example.demo.domain.campaign.Participantsvo;
import com.example.demo.domain.mypage.Uservo;
import com.example.demo.service.campaign.CampaignService;
import com.example.demo.service.campaign.ParticipantsService;

@Controller
public class ParticipantsController {

	@Autowired
	private ParticipantsService participantsService;
	
	@Autowired
	private CampaignService campaignService;
	
	@PostMapping("/participants")
	public String insertParticipants(Uservo uservo, Campaignvo campaignvo, Participantsvo participantsvo) {
		
		participantsvo.setUservo(uservo);
		participantsvo.setCampaignvo(campaignvo);
		participantsService.insertParticipants(participantsvo);
		
		Campaignvo campaignInfo = campaignService.getCampaign(campaignvo);
		campaignService.participantCountUp(campaignInfo);				
		
		return "redirect:getCampaign?campaignId="+campaignService.getCampaign(campaignvo).getCampaignId();
	}
	
	@PostMapping("/deleteParticipants")
	public String deleteParticipants(Uservo uservo, Campaignvo campaignvo) {
		
		participantsService.deleteParticipants(uservo.getUserId(), campaignvo.getCampaignId());
		Campaignvo campaignInfo = campaignService.getCampaign(campaignvo);
		campaignService.participantCountDown(campaignInfo);
		
		return "redirect:getCampaign?campaignId="+campaignService.getCampaign(campaignvo).getCampaignId();
	}
	
	@GetMapping("/selectParticipants")
	public String selectParticipants(int participantsId) {
		participantsService.selectParticipants(participantsId);
		return "redirect:getCampaignList";
	}
	
	@GetMapping("/cancleParticipants")
	public String cancleParticipants(int participantsId) {
		participantsService.cancleParticipants(participantsId);
		return "redirect:getCampaignList";
	}
	
}
