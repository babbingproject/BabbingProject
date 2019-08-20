package com.example.demo.service.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

	@Autowired
	AdvertisementRepository AdvertiseRepo;
	
	
}
