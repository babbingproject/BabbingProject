package com.example.demo.service.campaign;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.campaign.Campaignvo;

public interface CampaignRepository extends JpaRepository<Campaignvo, Integer>{

	List<Campaignvo> findAllByOrderByWriteDateDesc();
	List<Campaignvo> findAllByOrderByEndDateAsc();
	
	@Query(value= "select * from campaignvo where end_date > now()", nativeQuery=true)
	List<Campaignvo> findAllByActive();

}
