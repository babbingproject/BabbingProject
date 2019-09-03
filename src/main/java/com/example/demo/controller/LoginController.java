package com.example.demo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.service.login.LoginServiceImpl;
import com.example.demo.service.user.UserSha256;

@Controller
public class LoginController {

	@Autowired
	private LoginServiceImpl loginService;

	@RequestMapping(value = "/logincon", method = RequestMethod.POST)
	@ResponseBody
	public int userLoingPass(Uservo Uservo, HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("컨트롤러 왔습니다.");
		// userLogin.jsp에서 아이디기억하기 name값(remember) 가져오기
		String user_check = request.getParameter("remember_userId");
		System.out.println("user_check 찍힙니까?: "+request.getParameter("remember_userId"));
		// 암호화 확인
		System.out.println("user_pw 암호화전: " + Uservo.getPassword());

		// 비밀번호 암호화
		String user_pw = Uservo.getPassword();
		Uservo.setPassword(UserSha256.encrypt(user_pw));

		// 암호화 확인
		System.out.println("user_pw 암호화된것: " + Uservo.getPassword());
		// 로그인 메서드
		//int result = loginService.userLogin_service(Uservo, httpSession, user_check, response);
		
		int result= loginService.userLogin_service(Uservo,  user_check, httpSession);
		
		// 로그인 결과값
		if(result==1) {
						Cookie cookie = new Cookie("user_check", Uservo.getUserEmail());
						if (user_check.equals("true")) {
							response.addCookie(cookie);
							System.out.println("3단계-쿠키 아이디저장 O");

						} else {
							System.out.println("3단계-쿠키 아이디저장 X");
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}

						System.out.println("3단계-로그인단계");
						// 세션 저장하기 전에 비밀번호 가리기
						Uservo.setPassword("");

						// 세션에 vo 객체 저장
						httpSession.setAttribute("userSession", Uservo);
						System.out.println("회원아이디 세션 userSession : " + httpSession.getAttribute("userSession"));



						// 접속자 아이디를 세션에 담는다.
						httpSession.setAttribute("signedUser", Uservo.getUserEmail());
		
				}

	
		
System.out.println(result);
		return result;
	}
	
	@RequestMapping("/logout")
	public String userlogout() {
		return "logout";
	}
}
