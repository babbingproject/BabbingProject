package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.mypage.UserVO;

@Controller
public class UserController {

	@Autowired
	UserMapper userMapper;

	@RequestMapping("/")
	public String userMain() {
		return "th/main/homemain";
	}

	@RequestMapping("/joinForm")
	public String userJoinForm() {
		return "join";
	}

	@RequestMapping("/join")
	public String userJoin(UserVO userVO) {
		userMapper.joinUser(userVO);
		return "th/main/homemain";
	}

	@ResponseBody
	@RequestMapping("/emailCheck")
	public Integer emailCheck(@RequestBody UserVO vo) {
		int count = 0;
		count = userMapper.emailCheck(vo.getUser_email());
		// List<UserVO> list = userMapper.emailCheck2(vo.getUser_email());

		return count;
	}

	// 입력 받을때 vo 통째로 파라메터로 받고 get 메소드를 이용해서 값을 가져다가 넣어주고 ajax에서 data type 를 json으로
	// 해줄때 JSON.stringify({})를 추가해준다.
	@ResponseBody
	@RequestMapping("/nickCheck")
	public Integer nickCheck(@RequestBody UserVO vo) {
		int count = 0;
		count = userMapper.nickCheck(vo.getNickname());
		// List<UserVO> list = userMapper.emailCheck2(vo.getUser_email());

		return count;
	}

	
	
}
