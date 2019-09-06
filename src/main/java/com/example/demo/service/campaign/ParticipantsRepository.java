package com.example.demo.service.campaign;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.campaign.Participantsvo;

public interface ParticipantsRepository extends JpaRepository<Participantsvo, Integer> {
	
	// 캠페인 번호에 따른 응모자 리스트 호출
	@Query(value= "select * from participantsvo where campaign_id = ?1", nativeQuery = true)
	List<Participantsvo> getParticipantList(int campaignId);
	
	// 응모자 단일 객체 호출
	@Query(value="select * from participantsvo where advertisement_id = ?1 and campaign_id = ?2", nativeQuery = true)
	Participantsvo getParticipant(int advertisementId, int campaignId);
	
	// 응모 취소
	@Query(value="delete from participantsvo where advertisement_id = ?1 and campaign_id = ?2", nativeQuery = true)
	void deleteParticipants(int advertisement_id, int campaign_id);
}
