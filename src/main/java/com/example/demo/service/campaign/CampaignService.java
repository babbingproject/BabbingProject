package com.example.demo.service.campaign;

import java.util.List;

import com.example.demo.domain.campaign.Campaignvo;
import com.example.demo.domain.mypage.Advertisementvo;

public interface CampaignService {

	List<Campaignvo> getCampaignList(Campaignvo campaignvo);
	
	// 최신글 정렬
	List<Campaignvo> getListByWriteDate(Campaignvo campaignvo);
	// 마감임박순 정렬
	List<Campaignvo> getListByEndDate(Campaignvo campaignvo);
	// 현재 진행 중인 캠페인
	List<Campaignvo> getListByActive(Campaignvo campaignvo);

 	void insertCampaign(Campaignvo campaignvo);
	Campaignvo getCampaign(Campaignvo campaignvo);
	void updateCampaign(Campaignvo campaignvo);
	void deleteCampaign(Campaignvo campaignvo);
	
	// 참여자수 증가
	void participantCountUp(Campaignvo campaignvo);
	// 참여자수 감소
	void participantCountDown(Campaignvo campaignvo);
	
	
}