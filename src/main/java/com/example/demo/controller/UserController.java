package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.service.user.UserMailSendService;
import com.example.demo.service.user.UserService;
import com.example.demo.service.user.UserSha256;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserMailSendService mailsender;

	@RequestMapping("/")
	public String userMain() {
		return "th/main/homemain";
	}

	@RequestMapping("/joinForm")
	public String userJoinForm() {
		return "join";
	}

	@RequestMapping("/join")
//	public String userJoin(Uservo Uservo) {
//		userMapper.joinUser(Uservo);
	public String userJoin(Uservo Uservo, Model model, HttpServletRequest request) {
		// 받아온 비밀번호를 암호화 합니다.
		String encryPassword = UserSha256.encrypt(Uservo.getPassword());
		// 암호화된 비밀번호를 set해줍니다.
		Uservo.setPassword(encryPassword);
		// 회원가입 메서드
		userService.joinUser(Uservo);
		// 메일 보내기
		mailsender.mailSendWithUserKey(Uservo.getUserEmail(), Uservo.getNickname(), request);
		return "th/main/homemain";
	}

	@ResponseBody
	@RequestMapping("/emailCheck")

	public int emailCheck(@RequestBody Uservo vo) {
		return userService.emailCheck(vo, vo.getUserEmail());
	}

	// 입력 받을때 vo 통째로 파라메터로 받고 get 메소드를 이용해서 값을 가져다가 넣어주고 ajax에서 data type 를 json으로
	// 해줄때 JSON.stringify({})를 추가해준다.
	@ResponseBody
	@RequestMapping("/nickCheck")
	public int nickCheck(@RequestBody Uservo vo) {
		return userService.nickCheck(vo, vo.getNickname());
	}

	// e-mail 인증 컨트롤러
	@RequestMapping(value = "/user/key_alter", method = RequestMethod.GET)
	public String key_alterConfirm(@RequestParam("userEmail") String userEmail,
			@RequestParam("userKey") String key) {

		mailsender.alter_userKey_service(userEmail, key);

		return "regSuccess";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/loginss")
	public String loginss() {
		return "HomeMainJsp";
	}
}
