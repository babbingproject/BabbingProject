package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.service.user.PwSearchServiceImpl;
import com.example.demo.service.user.UserSha256;

@Controller
public class SearchController {
	@Autowired
	private PwSearchServiceImpl mailsender;
	// 비밀번호 찾기
	@RequestMapping("/user/searchPassword")
	public String userJoin(Uservo Uservo, HttpServletRequest request) {
		// 메일 보내기
		mailsender.mailSendWithPassword(Uservo.getUserEmail(), Uservo.getNickname(), request);
		return "th/main/homemain";
	}
	// 비밀번호 e-mail 인증 컨트롤러
	@RequestMapping(value = "/userpw/key_alter", method = RequestMethod.GET)
	public String key_alterConfirm(@RequestParam("userEmail") String userEmail, @RequestParam("password") String password) {
		//임시 발급된 비번을 암호화합니다.
		password = UserSha256.encrypt(password);
		return "pwSuccess";
	}
	
	@RequestMapping(value="/pwUpdate",method=RequestMethod.POST)
	public String pwUpdate(@RequestParam("userEmail") String userEmail, @RequestParam("password") String password) {
		//입력받은 새 비밀번호를 암호화합니다.
		System.out.println("새비번 컨트롤러 왔습니다");
		password = UserSha256.encrypt(password);
		System.out.println(userEmail);
		//새 비밀번호로 업데이트 합니다
		mailsender.searchPassword(userEmail, password);
		return "th/main/homemain";
	}
}