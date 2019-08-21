package com.example.demo.service.campaign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignServiceImpl implements CampaignService {
	@Autowired
	CampaignRepository CampaignRepo;
}
