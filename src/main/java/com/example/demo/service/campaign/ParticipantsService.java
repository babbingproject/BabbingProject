package com.example.demo.service.campaign;

import java.util.List;

import com.example.demo.domain.campaign.Participantsvo;

public interface ParticipantsService {
	
	List <Participantsvo> getParticipantsList(int campaign_id);
	
	Participantsvo getParticipants(int advertisement_id, int campaign_id);
	
	// 응모하기
	void insertParticipants(Participantsvo participants);
	// 응모취소
	void deleteParticipants(int advertisement_id, int campaign_id);	
	// 선정하기	
	void selectParticipants(int participants_id);
	// 선정취소
	void cancleParticipants(int participants_id);	
	
}
