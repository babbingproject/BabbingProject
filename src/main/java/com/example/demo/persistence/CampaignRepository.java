package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Campaignvo;

public interface CampaignRepository extends JpaRepository<Campaignvo, Integer>{

}
