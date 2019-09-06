package com.example.demo.service.advertisement;

import java.util.List;

import com.example.demo.domain.mypage.Advertisementvo;

public interface AdvertisementService {

	List<Object[]> getAdvertisementvoOrderByWeightAvg();

	List<Object[]> getSearchKeyword(String searchKeyword);

	public int joinAd(Advertisementvo vo);

	public int ademailCheck(Advertisementvo vo, String advertisement_email);

	public int adnickCheck(Advertisementvo vo, String advertisement_name);
}