package com.example.demo.service.campaign;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.campaign.Campaignvo;

public interface CampaignRepository extends JpaRepository<Campaignvo, Integer>{

}
