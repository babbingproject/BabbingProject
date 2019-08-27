package com.example.demo.service.advertisement;

import java.util.List;

public interface AdvertisementService {

	List<Object[]> getAdvertisementvoOrderByWeightAvg();

	List<Object[]> getSearchKeyword(String searchKeyword);

}