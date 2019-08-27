package com.example.demo.service.advertisement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementServiceImpl implements AdvertisementService  {

	@Autowired
	AdvertisementRepository advertiseRepo;
	@Override
	public List<Object[]> getAdvertisementvoOrderByWeightAvg(){
		return advertiseRepo.findAllbyAdvertisementidOrderByWeightedAvg();
		
	}
	
	//기업 서치
	
	@Override
	public List<Object[]> getSearchKeyword(String searchKeyword) {
		return advertiseRepo.getSearchKeyword(searchKeyword);
	}
	
}
