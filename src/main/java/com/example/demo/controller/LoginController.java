package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.mypage.Uservo;
import com.example.demo.service.login.LoginServiceImpl;
import com.example.demo.service.user.UserSha256;
import com.github.scribejava.core.model.OAuth2AccessToken;

@Controller
public class LoginController {

	@Autowired
	private LoginServiceImpl loginService;

	@RequestMapping(value = "/logincon", method = RequestMethod.POST)
	@ResponseBody
	public int userLoingPass(Uservo Uservo, HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response) {
		// userLogin.jsp에서 아이디기억하기 name값(remember) 가져오기
		String user_check = request.getParameter("remember_userId");
		// 암호화 확인
		// 비밀번호 암호화
		String user_pw = Uservo.getPassword();
		Uservo.setPassword(UserSha256.encrypt(user_pw));
		// 암호화 확인
		// 로그인 메서드
		int result = loginService.userLogin_service(Uservo, user_check, httpSession);
		// 로그인 결과값
		if (result == 1) {
			Cookie cookie = new Cookie("user_check", Uservo.getUserEmail());
			if (user_check.equals("true")) {
				response.addCookie(cookie);

			} else {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			// 세션 저장하기 전에 비밀번호 가리기
			Uservo.setPassword("");
			// 세션에 vo 객체 저장
			httpSession.setAttribute("userSession", Uservo);
			// 접속자 아이디를 세션에 담는다.
			httpSession.setAttribute("signedUser", Uservo.getUserEmail());
		}
		return result;
	}

	@RequestMapping("/logout")
	public String userlogout() {
		return "logout";
	}

	@RequestMapping("/userSearch")
	public String userSearch() {
		return "userSearch";
	}
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	//로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {
		
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		
		System.out.println("네이버:" + naverAuthUrl);
		
		//네이버 
		model.addAttribute("url", naverAuthUrl);

		/* 생성한 인증 URL을 View로 전달 */
		return "login";
	}

	//네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException {
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        //로그인 사용자 정보를 읽어온다.
	    apiResult = naverLoginBO.getUserProfile(oauthToken);
		model.addAttribute("result", apiResult);

        /* 네이버 로그인 성공 페이지 View 호출 */
		return "naverSuccess";
	}
}


