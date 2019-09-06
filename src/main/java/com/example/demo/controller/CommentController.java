package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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
	@ResponseBody
	public Optional<Commentvo> commentList(@ModelAttribute("uservo") Uservo uservo, ReviewRegistrationvo
		reviewRegistrationvo, Commentvo commentvo, Model model) { 
		/*
		 * if (uservo.getNickname() == null) { // nickname대신 userId로 조건을 줘야하나? return
		 * "redirect:login"; }
		 */
//		commentService.selectCommentListAllById(reviewRegistrationvo.getReviewId());
		System.out.println(reviewRegistrationvo.toString());
		Optional<Commentvo> commentList = commentService.selectCommentListAllById(reviewRegistrationvo.getReviewId());
//		model.addAttribute("commentList", commentList);
		System.out.println(commentList.toString());
//	  return "th/review/testComment"; 
	  return commentList;
	  }

	/*
	 * @RequestMapping("commentList") public String commentList() {
	 * 
	 * return "th/review/testComment"; }
	 */
	@RequestMapping(value="/addComment", method = RequestMethod.POST)
	@ResponseBody
	public List<Commentvo> addComment(@ModelAttribute("uservo") Uservo uservo, Commentvo commentvo, ReviewRegistrationvo reviewRegistrationvo) { 
		System.out.println(" 권 선생님 ");
		System.out.println(uservo.toString());
		
		commentvo.setUservo(uservo);
		System.out.println(uservo.toString());
		System.out.println(reviewRegistrationvo.toString());
		commentvo.setReviewRegistrationvo(reviewRegistrationvo);
		commentService.insertComment(commentvo);
		
		List<Commentvo> commentList =  commentService.selectCommentList(reviewRegistrationvo);
		
		System.out.println(commentList);
		return commentList; 
	}
	@RequestMapping("test")
	public String testPage() {
		return "th/review/testComment";
	}
}