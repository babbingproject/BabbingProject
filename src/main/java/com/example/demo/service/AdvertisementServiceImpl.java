package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.AdvertisementRepository;


@Service
public class AdvertisementServiceImpl implements AdvertisementService {

	@Autowired
	AdvertisementRepository AdvertiseRepo;
	
	
}
