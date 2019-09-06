package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.service.user.UserService;

// 이 클래스는 단지 작업에서 세션을 쓰기위해서 만든것
@SessionAttributes("uservo")
@Controller
public class LoginTestReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginTestReviewController.class); 

	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/reviewIndex")
	public String reviewIndex() {
		return "th/review/reviewIndex";
	}
	
	@GetMapping("/login")
	public String loginReview() {
		return "th/review/loginReview";
	}
	@PostMapping("/login")
	public String login(Uservo uservo, Model model) {
//		logger.info(uservo.toString());
		Uservo findUservo = userService.getUser(uservo);
		
		if (findUservo !=null
				&& findUservo.getPassword().equals(uservo.getPassword())) {
			model.addAttribute("uservo", findUservo);
//			System.out.println(model.toString());
			return "forward:doReviewList";
		}else {
			return "redirect:login";
		}
	}
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/index";
	}
}
