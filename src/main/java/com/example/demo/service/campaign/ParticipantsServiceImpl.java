package com.example.demo.service.campaign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.campaign.Participantsvo;

@Service
public class ParticipantsServiceImpl implements ParticipantsService {

	@Autowired
	private ParticipantsRepository participantsRepo;
	
	@Override
	public List<Participantsvo> getParticipantsList(int campaign_id) {
		return (List<Participantsvo>) participantsRepo.getParticipantList(campaign_id);
	}

	@Override
	public Participantsvo getParticipants(int advertisement_id, int campaign_id) {
		return participantsRepo.getParticipant(advertisement_id, campaign_id);
	}

	@Override
	public void insertParticipants(Participantsvo participants) {
		participantsRepo.save(participants);

	}

	@Override
	public void deleteParticipants(int advertisement_id, int campaign_id) {
		participantsRepo.deleteParticipants(advertisement_id, campaign_id);	

	}

	@Override
	public void selectParticipants(int participants_id) {
		Participantsvo participantsvo = participantsRepo.findById(participants_id).get();
		participantsvo.setParticipation('Y');
		participantsRepo.save(participantsvo);

	}

	@Override
	public void cancleParticipants(int participants_id) {
		Participantsvo participantsvo = participantsRepo.findById(participants_id).get();
		participantsvo.setParticipation('N');
		participantsRepo.save(participantsvo);
	}
}
