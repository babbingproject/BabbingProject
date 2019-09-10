package com.example.demo.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.domain.review.Commentvo;
import com.example.demo.domain.review.Commentvo2;
import com.example.demo.domain.review.ReviewRegistrationvo;
import com.example.demo.service.review.CommentRepository;
import com.example.demo.service.review.CommentService;
import com.example.demo.service.review.ReviewRepository;
import com.example.demo.service.user.UserRepository;

@Controller
public class CommentController {

	@Autowired
	CommentService commentService;

	@Autowired
	ReviewRepository reviewRepo;
	@Autowired
	CommentRepository commentRepo;

	@Autowired
	UserRepository userRepo;

	@RequestMapping("deleteComment")
	@ResponseBody
	public void removeComment(int commentId) {
		System.out.println("controller commentId"+commentId);
		commentService.deleteComment(commentId);
	}

	/*
	 * @RequestMapping("/commentList")
	 * 
	 * @ResponseBody public List<Commentvo> commentList(@ModelAttribute("uservo")
	 * Uservo uservo, ReviewRegistrationvo reviewRegistrationvo, Commentvo
	 * commentvo, Model model) {
	 * 
	 * if (uservo.getNickname() == null) { // nickname대신 userId로 조건을 줘야하나? return
	 * "redirect:login"; }
	 * 
	 * //
	 * commentService.selectCommentListAllById(reviewRegistrationvo.getReviewId());
	 * System.out.println(reviewRegistrationvo.toString()); List<Commentvo>
	 * commentList = commentService.selectCommentList(); //
	 * model.addAttribute("commentList", commentList);
	 * System.out.println(commentList.toString()); // return
	 * "th/review/testComment"; return commentList; }
	 */

	/*
	 * @RequestMapping("commentList") public String commentList() {
	 * 
	 * return "th/review/testComment"; }
	 */

	@RequestMapping("commentList")
	@ResponseBody
	public List<Commentvo> commentList(Uservo uservo, ReviewRegistrationvo reviewRegistrationvo) {

		List<Commentvo> commentList = new ArrayList<>();

		reviewRegistrationvo.setReviewId(reviewRegistrationvo.getReviewId());
		Commentvo commentvo = new Commentvo();
		commentvo.setReviewRegistrationvo(reviewRegistrationvo);
		commentvo.setUservo(uservo);
		commentService.selectCommentList(reviewRegistrationvo);

		commentList = commentService.selectCommentList(reviewRegistrationvo);

		return commentList;
	}

	@RequestMapping(value = "addComment", produces = "application/json; charset=utf8")
	@ResponseBody
	public Commentvo2 addComment(Uservo uservo, Commentvo commentvo, ReviewRegistrationvo reviewRegistrationvo
			) {

		System.out.println(uservo.getNickname().toString());
		System.out.println(reviewRegistrationvo.toString());
		commentvo.setUservo(uservo);
		commentvo.setReviewRegistrationvo(reviewRegistrationvo);
		commentRepo.save(commentvo);

		System.out.println(commentvo.toString());

		List<Commentvo> commentList = commentRepo.findByReviewRegistrationvo(reviewRegistrationvo);

//		System.out.println(commentList.toString());

//		commentService.insertComment(commentvo);

		Commentvo2 commentvo2 = new Commentvo2();
		commentvo2.setContents(commentList.get(commentList.size() - 1).getContents());
		commentvo2.setReviewId(reviewRegistrationvo.getReviewId());
		commentvo2.setUserId(uservo.getUserId());
		commentvo2.setNickName(uservo.getNickname());
		commentvo2.setCommentId(commentvo.getCommentId());
		/*
		 * commentvo2.setWriteDate(commentvo.getWriteDate().toString());
		 * commentvo2.setModifyDate(commentvo.getModifiedDate().toString());
		 */
//		Map<String, Commentvo> comment = new HashMap<>();
//		comment.put("commentvo", commentvo);

//		Commentvo2 com = new Commentvo2();
//		com.setContents(commentvo.getContents());
//		com.setReviewId(commentvo.getReviewRegistrationvo().getReviewId());
//		com.setUserId(commentvo.getUservo().getUserId());
//		com.set(commentvo.getUservo().getNickname());

		return commentvo2;
	}

	@RequestMapping("test")
	public String testPage() {
		return "th/review/testComment";
	}
}