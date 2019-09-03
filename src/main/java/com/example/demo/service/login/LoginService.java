package com.example.demo.service.login;


import javax.servlet.http.HttpSession;

import com.example.demo.domain.mypage.Uservo;

public interface LoginService {

	/*
	 * public int userLogin_service(Uservo Uservo, HttpSession httpSession, String
	 * user_check, HttpServletResponse responsez);
	 */
	/*
	 * int userLogin_service(Uservo Uservo, String user_check);
	 */
	int userLogin_service(Uservo Uservo, String user_check, HttpSession session);


}