package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.advertisement.AdvertisementService;

@Controller
public class AdvertisementController {
	
	@Autowired
	AdvertisementService advertisementService;
	
	@RequestMapping("/homeadvlist")
	public String getAdvertisementList(Model model) {
		List<Object[]> advvoList = advertisementService.getAdvertisementvoOrderByWeightAvg();
		model.addAttribute("advvoList", advvoList);
		System.out.println(advvoList);
		return "th/main/homemain.html";
	}
}
