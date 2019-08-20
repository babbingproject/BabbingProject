package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.service.user.UserService;

@Controller
public class HomeMainController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/home")
	public String goIndex() {
		
		return "main/homemain";
	}
	
	@RequestMapping("/index")
	public String goIndex1() {
		
		return "main/index";
	}
	
	@RequestMapping("/board")
	public String goBoard() {
		return "board";
	}
	
	//태원의 메인홈 테스팅 메소드. 화면 정보 열로 다 뿌려주기
//	@RequestMapping("/taewonhome")
//	public String getHomeMain(Uservo uservo, Model model) {
//		List<Uservo> uservoList = userService.getUservoList(uservo);
//		model.addAttribute("uservo", uservoList);
//		System.out.println(uservoList);
//		return "main/homemain";
//	}
	
	//태원의 제2의 메인홈 테스팅 메소드. 화면 정보 다 뿌려주자자자자자
	@RequestMapping("/taewonhome")
	public String getHomeMain(Uservo uservo, Model model) {
		List<Uservo> uservoList = userService.getUservoListOrderByFollowingCountDes(uservo);
		model.addAttribute("uservo", uservoList);
		System.out.println(uservoList);
		return "main/homemain";
	}
}
