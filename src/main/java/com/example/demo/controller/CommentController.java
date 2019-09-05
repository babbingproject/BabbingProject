package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.Commentvo;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.example.demo.service.review.CommentService;

@SessionAttributes("uservo")
@Controller()
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	
	
	@RequestMapping("/commentList") 
	public String
	  commentList(@ModelAttribute("uservo") Uservo uservo, ReviewRegistrationvo
	  reviewRegistrationvo, Commentvo commentvo, Model model) { if
	  (uservo.getNickname() == null) { // nickname대신 userId로 조건을 줘야하나? 
		  return "redirect:login"; }
	  
	  return "th/review/testComment"; 
	  }

	/*
	 * @RequestMapping("commentList") public String commentList() {
	 * 
	 * return "th/review/testComment"; }
	 */
	@RequestMapping(value="/addComment", method = RequestMethod.POST)
	@ResponseBody
	public String addComment(@ModelAttribute("uservo") Uservo uservo, String contents, ReviewRegistrationvo reviewRegistrationvo) { 
		System.out.println(" 권 선생님 ");
		System.out.println(uservo.toString());
		if
		  (uservo.getNickname() == null) { // nickname대신 userId로 조건을 줘야하나? 
			  return "redirect:login"; }
		  
		
		Commentvo commentvo = new Commentvo();
		
		commentvo.setUservo(uservo);
		reviewRegistrationvo.setReviewId(reviewRegistrationvo.getReviewId());
		System.out.println(uservo.toString());
		commentvo.setContents(contents);
		commentvo.setReviewRegistrationvo(reviewRegistrationvo);
		commentService.insertComment(commentvo);
		
		return "th/review/testComment"; 
	}
	@RequestMapping("test")
	public String testPage() {
		return "th/review/testComment";
	}
}