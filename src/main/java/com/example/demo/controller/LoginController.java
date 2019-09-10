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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.domain.mypage.Advertisementvo;
import com.example.demo.domain.mypage.Uservo;
import com.example.demo.service.advertisement.AdvertisementRepository;
import com.example.demo.service.login.LoginRepository;
import com.example.demo.service.login.LoginServiceImpl;
import com.example.demo.service.user.UserSha256;
import com.github.scribejava.core.model.OAuth2AccessToken;

@Controller
public class LoginController {

	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private LoginRepository loginRepo;
	
	@Autowired
	private AdvertisementRepository adverRepo;
	
	
	@RequestMapping(value = "/logincon", method = RequestMethod.POST)
	@ResponseBody
	public int userLoingPass(Uservo Uservo, HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response, Model model) {
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
			Cookie cookie = new Cookie("user_check", Uservo.getUser_email());
			if (user_check.equals("true")) {
				response.addCookie(cookie);

			} else {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			// 세션 저장하기 전에 비밀번호 가리기
			Uservo.setPassword("");
			// 세션에 vo 객체 저장
			String nickName = loginRepo.selectNickName(Uservo.getUser_email());
			// 닉네임을 세션에 담는다
			httpSession.setAttribute("nickName", nickName);
			System.out.println(nickName);
			
			httpSession.setAttribute("userSession", Uservo);
			// 접속자 아이디를 세션에 담는다.
			httpSession.setAttribute("signedUser", Uservo.getUser_email());
			String userId = loginRepo.selectUserId(nickName);
			// userId를 세션에 담는다
			httpSession.setAttribute("userId", userId);
			
		}
		return result;
	}

	@RequestMapping("/login")
	public String login() {
//		return "login";
		return "th/review/loginReview";
	}
	@RequestMapping("/adLogin")
	public String adlogin() {
		return "adLogin";
	}

	@RequestMapping("/loginss")
	public String loginss() {
		return "th/main/index1";
	}

	@RequestMapping("/logout")
	public String userlogout() {
		return "logout";
	}

	@RequestMapping("/userSearch")
	public String userSearch() {
		return "userSearch";
	}
	@RequestMapping("/adUserSearch")
	public String adUserSearch() {
		return "adUserSearch";
	}

	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	@RequestMapping(value = "/adLogincon", method = RequestMethod.POST)
	@ResponseBody
	public int adLoingPass(Advertisementvo vo, HttpSession httpSession, HttpServletRequest request,
			HttpServletResponse response) {
		// userLogin.jsp에서 아이디기억하기 name값(remember) 가져오기
		String user_check = request.getParameter("remember_userId");
		// 암호화 확인
		// 비밀번호 암호화
		String user_pw = vo.getPassword();
		vo.setPassword(UserSha256.encrypt(user_pw));
		// 암호화 확인
		// 로그인 메서드
		int result = loginService.adLogin_service(vo, user_check, httpSession);
		// 로그인 결과값
		if (result == 1) {
			Cookie cookie = new Cookie("user_check", vo.getAdvertisement_email());
			if (user_check.equals("true")) {
				response.addCookie(cookie);

			} else {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			// 세션 저장하기 전에 비밀번호 가리기
			vo.setPassword("");
			// 세션에 vo 객체 저장
			httpSession.setAttribute("adUserSession", vo);			
			// 접속자 아이디를 세션에 담는다.
			httpSession.setAttribute("adSignedUser", vo.getAdvertisement_email());
			// 사업자 명을 세션에 담는다
			httpSession.setAttribute("adName", adverRepo.selectAdvertisementName(vo.getAdvertisement_email()));
			String adName = adverRepo.selectAdvertisementName(vo.getAdvertisement_email());
			// 사업자 번호를 세션에 담는다
			httpSession.setAttribute("adNum", adverRepo.selectAdvertisementNum(adName));
			
			
		}
		return result;
	}

	// 로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {

		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

		// 네이버
		model.addAttribute("url", naverAuthUrl);

		/* 생성한 인증 URL을 View로 전달 */
//		return "login";
		return "login";
	}

	// 네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException {
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		// 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken);
		model.addAttribute("result", apiResult);

		/* 네이버 로그인 성공 페이지 View 호출 */
		return "naverSuccess";
	}
}
